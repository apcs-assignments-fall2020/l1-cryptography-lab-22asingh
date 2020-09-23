import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        int shift;
        int nonLetterCount = 0;
        char ch;
        String newStr = "";
        for (int i = 0; i < message.length(); i++){
            shift = (int) (key.charAt((i - nonLetterCount) % key.length()) - 65);
            ch = message.charAt(i);
            if ((ch >= 65 && ch <= 90)||(ch >= 97 && ch <= 122)){
                if ((ch >= (90 - (shift - 1)) && ch <= 90)||(ch >= (122 - (shift - 1)) && ch <= 122)){
                    newStr += (char)(ch - (26 - shift));
                }
                else{
                    newStr += (char)(ch + shift);
                }
            }
            else{
                newStr += ch;
                nonLetterCount += 1;
            }
        }
        return newStr;
    }

    public static String decryptVigenere(String message, String key) {
        int shift;
        int nonLetterCount = 0;
        char ch;
        String newStr = "";
        for (int i = 0; i < message.length(); i++){
            shift = (int) (key.charAt((i - nonLetterCount) % key.length()) - 65);
            ch = message.charAt(i);
            if ((ch >= 65 && ch <= 90)||(ch >= 97 && ch <= 122)){
                if ((ch >= 65 && ch <= (65 + (shift - 1)))||(ch >= 97 && ch <= (97 + (shift - 1)))){
                    newStr += (char)(ch + (26 - shift));
                }
                else{
                    newStr += (char)(ch - shift);
                }
            }
            else{
                newStr += ch;
                nonLetterCount += 1;
            }
        }
        return newStr;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
