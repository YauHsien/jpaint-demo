package id.yauhsien.demo.paint;

import id.yauhsien.demo.paint.ui.MessageEnum;
import id.yauhsien.demo.paint.ui.Session;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStreamReader;
import java.io.StringReader;

@SpringBootApplication
public class App implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Session session = new Session();
        if (args.length == 0)
            session.doReadEvalPrintLoop(MessageEnum.EnterCommand, new InputStreamReader(System.in));
        else
            session.doReadEvalPrintLoop(MessageEnum.Nothing, new StringReader(StringEscapeUtils.unescapeJava(args[0])));
    }
}
