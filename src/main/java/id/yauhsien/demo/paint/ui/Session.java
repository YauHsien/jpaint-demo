package id.yauhsien.demo.paint.ui;

import id.yauhsien.demo.paint.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class Session {

    private Canvas canvas;

    public void doReadEvalPrintLoop(MessageEnum prompt, Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        StageEnum stage = StageEnum.Init;
        boolean loop = true;
        do {
            String cmdLine;
            if (prompt == MessageEnum.Nothing) {
                cmdLine = bufferedReader.readLine();
                cmdLine = cmdLine.trim();
                System.out.println(cmdLine);
            }
            else{
                System.out.print(prompt.toString());
                cmdLine = bufferedReader.readLine().trim();
            }
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
            if (loop == true && this.canvas != null)
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
}
