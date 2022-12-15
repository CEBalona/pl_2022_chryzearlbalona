import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Semantic
{
    public static void main(String[] args)
    {

        String str;
        String regExPattern = "(('|\").*\\s*.*(\"|'))|;|=|(-|\\+)*(\\.*\\w+\\.*\\w*)";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Expression: ");
        str = scanner.nextLine();

        while(true)
        {
            boolean isValueAssign = false;
            DataType dataValue = DataType.error;
            String value="";
            Matcher matcher = Pattern.compile(regExPattern).matcher(str);

            while(matcher.find())
            {
                if(matcher.group().equals("="))
                {
                    isValueAssign=true;
                    continue;
                }
                if(IsDataType(matcher.group())){
                    dataValue = GetDataType(matcher.group());
                    continue;
                }
                if(isValueAssign && IsValueType(matcher.group())){
                    value = matcher.group();
                    break;
                }
            }
            if(!isValueAssign|IsTypeMatched(value,dataValue))
            {
                System.out.println("\nSemantically  Correct!\n");
            }
            else
            {
                System.out.println("\nSemantically  Incorrect!\n");
            }
            break;
        }
    }
    static boolean IsDataType(String input)
    {
        return input.equals("int")||input.equals("double")||
                input.equals("String")||input.equals("char");
    }
    static DataType GetDataType(String input)
    {
        return switch (input) {
            case "String" -> DataType.StringType;
            case "char" -> DataType.charType;
            case "int" -> DataType.intType;
            case "double" -> DataType.doubleType;
            default -> DataType.error;
        };
    }

    static boolean IsValueType(String input)
    {
        String regExPattern = "(-*\\d+)|" +         //int
                              "(\\d+\\.*\\d*)|" +   //double
                              "(\".+\")|" +         //String
                              "('.')";              //char
        Matcher matcher = Pattern.compile(regExPattern).matcher(input);
        return matcher.find();
    }
    static boolean IsTypeMatched(String input, DataType dataType)
    {
        String charPatternValue ="((\'.\'))";
        String stringPatternValue ="(\".*\")";
        String intPatternValue ="(-|\\+)?\\d+";
        String doublePatternValue ="((-|\\+)?((\\d+)|(\\d+\\.*\\d*)|(\\d*\\.*\\d+)))";
        String regExValue = switch (dataType) {
            case StringType -> stringPatternValue;
            case charType -> charPatternValue;
            case intType -> intPatternValue;
            case doubleType -> doublePatternValue;
            default -> null;
        };

        if(regExValue==null)
        {
            return false;
        }
        Matcher matcher = Pattern.compile(regExValue).matcher(input);
        return matcher.matches();
    }

    public enum DataType
    {
        StringType,charType,intType,doubleType,error
    }
}
