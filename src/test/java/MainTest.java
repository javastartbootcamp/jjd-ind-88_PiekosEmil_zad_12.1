import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void shouldWorkForAddition() throws IOException {
        // given
        String fileContent = "1 + 2";
        writeToInputFile(fileContent);

        // when
        Main.main(new String[]{});

        // then
        assertThat(outContent.toString()).contains("1.0 + 2.0 = 3.0");
    }

    @Test
    void shouldWorkForMultiply() throws IOException {
        // given
        String fileContent = "2 * 3";
        writeToInputFile(fileContent);

        // when
        Main.main(new String[]{});

        // then
        assertThat(outContent.toString()).contains("2.0 * 3.0 = 6.0");
    }

    @Test
    void shouldWorkForDivision() throws IOException {
        // given
        String fileContent = "10 / 2";
        writeToInputFile(fileContent);

        // when
        Main.main(new String[]{});

        // then
        assertThat(outContent.toString()).contains("10.0 / 2.0 = 5.0");
    }

    @Test
    void shouldWorkForSubstract() throws IOException {
        // given
        String fileContent = "10 - 2";
        writeToInputFile(fileContent);

        // when
        Main.main(new String[]{});

        // then
        assertThat(outContent.toString()).contains("10.0 - 2.0 = 8.0");
    }

    private void writeToInputFile(String fileContent) throws IOException {
        File file = new File("operations.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(fileContent);
        fileWriter.close();
    }

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outContent));
    }


    @AfterEach
    void cleanup() {
        System.setOut(originalOut);
    }

}
