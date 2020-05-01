package id.yauhsien.demo.paint.ui;

import id.yauhsien.demo.paint.model.*;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadEvalPrintLoop {

    private Canvas canvas;

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StageEnum stage = StageEnum.Init;
        boolean loop = true;
        do {
            System.out.print(MessageEnum.EnterCommand);
            String cmdLine = bufferedReader.readLine().trim();
            String[] commandLine = cmdLine.split("\\s+");
            try {
                stage = StageEnum.CmdCheck;
                CommandEnum commandEnum = CommandEnum.valueOf(commandLine[0].trim().toUpperCase());
                switch (commandEnum) {
                    case C:
                        if (commandLine.length != 3)
                            throw new IllegalArgumentException();
                        this.canvas = new Canvas(
                                Integer.parseInt(commandLine[1].trim()),
                                Integer.parseInt(commandLine[2].trim()));
                        break;
                    case L:
                        if (commandLine.length != 5)
                            throw new IllegalArgumentException();
                        stage = StageEnum.LogicCheck;
                        if (this.canvas == null)
                            throw new IllegalArgumentException(MessageEnum.NoCanvas.toString());
                        Line line = new Line(
                                Integer.parseInt(commandLine[1].trim()),
                                Integer.parseInt(commandLine[3].trim()),
                                Integer.parseInt(commandLine[2].trim()),
                                Integer.parseInt(commandLine[4].trim()));
                        this.canvas.applyShape(line);
                        break;
                    case R:
                        if (commandLine.length != 5)
                            throw new IllegalArgumentException();
                        stage = StageEnum.LogicCheck;
                        if (this.canvas == null)
                            throw new IllegalArgumentException(MessageEnum.NoCanvas.toString());
                        Rectangle rectangle = new Rectangle(
                                Integer.parseInt(commandLine[1].trim()),
                                Integer.parseInt(commandLine[3].trim()),
                                Integer.parseInt(commandLine[2].trim()),
                                Integer.parseInt(commandLine[4].trim()));
                        this.canvas.applyShape(rectangle);
                        break;
                    case B:
                        if (commandLine.length != 4)
                            throw new IllegalArgumentException();
                        ColorEnum colorEnum = ColorEnum.valueOf(commandLine[3].trim());
                        stage = StageEnum.LogicCheck;
                        if (this.canvas == null)
                            throw new IllegalArgumentException(MessageEnum.NoCanvas.toString());
                        BucketPainting bucketPainting = new BucketPainting(
                                Integer.parseInt(commandLine[1].trim()),
                                Integer.parseInt(commandLine[2].trim()),
                                colorEnum);
                        this.canvas.applyShape(bucketPainting);
                        break;
                    case Q:
                        System.out.println(MessageEnum.OK.toString());
                        loop = false;
                        break;
                }
            }
            catch (NumberFormatException ex) {
                if (stage == StageEnum.CmdCheck)
                    System.out.println(MessageEnum.BadCommand.toString());
                else
                    throw ex;
            }
            catch (IllegalArgumentException ex) {
                switch (stage) {
                    case CmdCheck:
                        System.out.println(MessageEnum.BadCommand.toString());
                        break;
                    case LogicCheck:
                        System.out.println(ex.getMessage());
                        break;
                    default:
                        throw ex;
                }
            }
            stage = StageEnum.Print;
            if (this.canvas != null)
                System.out.println(this.canvas.toString());
        }
        while (loop);
    }

    private static enum StageEnum {

        Init("Initial"),
        CmdCheck("Checking command"),
        LogicCheck("Checking logic"),
        Print("Print canvas");

        private String meaning;

        StageEnum(String meaning) {
            this.meaning = meaning;
        }
    }

    private static enum MessageEnum {
        EnterCommand("Enter command: "),
        BadCommand("Bad command.\n"),
        NoCanvas("No canvas.\n"),
        OK("OK.");

        private String meaning;

        MessageEnum(String meaning) {
            this.meaning = meaning;
        }

        @Override
        public String toString() {
            return meaning;
        }
    }
}
