import java.util.Scanner;

public class Automata
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");

        String state = "q0";
        String input = sc.next();

        for (int x = 0; x < input.length(); x++)
        {
            if (state.equals("q0") && input.charAt(x) == '0')
            {
                state = "q1";
            }
            else if (state.equals("q0") && input.charAt(x) == '1')
            {
                state = "q0";
            }
            else if (state.equals("q1") && input.charAt(x) == '0')
            {
                state = "q1";
            }
            else if (state.equals("q1") && input.charAt(x) == '1')
            {
                state = "q2";
            }
            else if (state.equals("q2") && input.charAt(x) == '0')
            {
                state = "q1";
            }
            else if (state.equals("q2") && input.charAt(x) == '1')
            {
                state = "q0";
            }
            else
            {
                System.out.println("Invalid input");
            }
        }

        if (state.equals("q2"))
        {
            System.out.println("String accepted");
        }
        else
        {
            System.out.println("String not accepted");
        }
    }
}
