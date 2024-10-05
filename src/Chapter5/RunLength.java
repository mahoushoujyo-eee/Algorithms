package Chapter5;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RunLength
{
    public static void expand() throws FileNotFoundException
    {
        boolean b = false;
        Scanner input = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter("test.txt");
        while (input.hasNext())
        {
            char cnt = 'a';
            for (int i = 0; i < cnt; i++)
                printWriter.print(b);
            b = !b;
        }
        printWriter.close();
    }

    public static void compress() throws FileNotFoundException {
        char cnt = 0;
        boolean b, old = false;
        Scanner input = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter("test.txt");
        while(input.hasNext())
        {
            b = input.nextBoolean();
            if (b != old)
            {
                printWriter.print(cnt);
                cnt = 0;
                old = !old;
            }
            else
            {
                if (cnt == 255)
                {
                    printWriter.print(cnt);
                    cnt = 0;
                    printWriter.print(cnt);
                }
            }
            cnt++;
        }
        printWriter.print(cnt);
        printWriter.close();
    }
}
