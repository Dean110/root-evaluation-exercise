package driving_history_reporter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {
    private Application underTest;
    private PrintStream out;
    private ByteArrayOutputStream byteArrayOutputStream;
    private PrintStream testPrintStream;
    @BeforeEach
    public void setup(){
        underTest = new Application();
        byteArrayOutputStream = new ByteArrayOutputStream();
        testPrintStream = new PrintStream(byteArrayOutputStream);
        System.setOut(testPrintStream);
    }
    @Test
    public void shouldOutputExampleOutput(){
        underTest.main(new String[]{"sample-input.txt"});
        assertThat(byteArrayOutputStream.toString())
                .isEqualTo("Lauren: 42 miles @ 34 mph\n" +
                        "Dan: 39 miles @ 47 mph\n" +
                        "Kumi: 0 miles");
    }
}