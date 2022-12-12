import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Parser
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter your Program: ");

        List<String> tokenList = new ArrayList();
        String str = scan.nextLine();
        String con = "";
        con = con.concat(str + " ");

        System.out.print("Tokens: ");
        String output[] = con.split(" ");


        for(int i = 0; i<output.length;i++)
        {
            if (null!=output[i])
            {
                switch(output[i])
                {
                    case "String", "int", "float", "double", "boolean", "char":
                        System.out.print("<data_type>");
                        tokenList.add("<data_type>");
                        break;
                    case "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
                            "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" , "num", "number", "str":
                        System.out.print("<identifier>");
                        tokenList.add("<identifier>");
                        break;
                    case "=", "+", "-", "*", "/", "==":
                        System.out.print("<assignment_operator>");
                        tokenList.add("<assignment_operator>");
                        break;
                    case ";":
                        System.out.print("<delimiter>");
                        tokenList.add("<delimiter>");
                        break;
                    case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "\"":
                        System.out.print("<value>");
                        tokenList.add("<value>");
                        break;
                }
            }

        }

        List<String> syntaxListOne = new ArrayList<String>
                (Arrays.asList("<data_type>", "<identifier>", "<assignment_operator>", "<value>", "<delimiter>"));
        List<String> syntaxListTwo = new ArrayList<String>
                (Arrays.asList("<data_type>", "<identifier>", "<delimiter>"));

        if(syntaxListOne.equals(tokenList))
        {
            System.out.println("\n\nSyntax is correct!");
        }
        else if(syntaxListTwo.equals(tokenList))
        {
            System.out.println("\n\nSyntax is correct!");
        }
        else
        {
            System.out.println("Syntax is Error!");
        }
    }

}

