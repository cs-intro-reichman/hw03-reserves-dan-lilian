/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String s) {
        String newString = "";
        for (int i= 0; i<=(s.length()-1);i++)
        {
            char currentChar = s.charAt(i);
            if (currentChar>64 && currentChar<91)
            {
                currentChar= (char)(currentChar+32);
                newString= newString+currentChar;
            } else {
                      newString= newString+currentChar;
                   }
        }
        // Replace the following statement with your code
        return newString;
    }
}