import java.util.Scanner;
import java.util.regex.Pattern;

public class Tokenizer
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter your Program: ");

        String str = scan.nextLine();
        String con = "";
        con = con.concat(str + " ");
        System.out.println();

        System.out.print("Output is: ");
        String[] output = con.split(" ");

        int i = 0;
        while (i<output.length) {
            if (null!=output[i])
            {
                switch (output[i]) {
                    case "String", "int", "float", "double", "boolean", "char" -> System.out.print("<data_type>");
                    case "=" -> System.out.print("<assingment_operator>");
                    case ";" -> System.out.print("<delimiter>");
                    case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "\"Hello" -> System.out.print("<value>");
                }

                if(Pattern.matches("[a-zA-Z]" , output[i]))
                {
                    System.out.print("<identifier>");
                }
                if(Pattern.matches("num" , output[i]))
                {
                    System.out.print("<identifier>");
                }
                if(Pattern.matches("number" , output[i]))
                {
                    System.out.print("<identifier>");
                }
                if(Pattern.matches("str" , output[i]))
                {
                    System.out.print("<identifier>");
                }
            }
            i++;
        }

    }
}
