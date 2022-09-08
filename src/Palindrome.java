import java.util.Scanner;

public class Palindrome
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a word/phrase: ");

        String str = sc.nextLine();

        String newStr = str.replaceAll("[^a-zA-Z0-9]", "");

        StringBuilder reverseStr = new StringBuilder();
        int length = newStr.length();

        for(int i = length -1; i>=0; i--)
        {
            reverseStr.append(newStr.charAt(i));
        }

        newStr = newStr.toLowerCase();
        reverseStr = new StringBuilder(reverseStr.toString().toLowerCase());


        if (newStr.equals(reverseStr.toString()))
        {
            System.out.println(str + " is a Palindrome");
        }
        else
        {
            System.out.println(str + " is not Palindrome");
        }

    }
}
