package id.yauhsien.demo.paint;

import id.yauhsien.demo.paint.ui.ReadEvalPrintLoop;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReference;

@SpringBootApplication
public class App implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ReadEvalPrintLoop repl = new ReadEvalPrintLoop();
        repl.init();
    }
}
