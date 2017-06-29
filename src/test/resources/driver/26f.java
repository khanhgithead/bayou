// internal method call
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

class Test {
    BufferedReader br;
    public Test(File file) {
        br = new BufferedReader(new FileReader(file));
    }

    public void doTest() {
        String s;
        int i;
        for (i = 0; i < 10; i++)
            System.out.println(i);
        try {
            if (br.ready())
                while ((s = br.readLine() != null))
                    System.out.println(s);
            else
                close();
        } catch (IOException e) {
            close();
        }
    }

    private void close() {
        br.close();
    }
}