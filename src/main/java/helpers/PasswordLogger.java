package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PasswordLogger {

    public static String[] getLastPasswords(){
        String[] passwords = new String[2];

        try {
            Scanner scanner = new Scanner(new File
                    (ConfigProvider.PASSWORD_HISTORY_FILE_PATH));
            passwords[0] = scanner.nextLine().split("=")[1];
            passwords[1]  = scanner.nextLine().split("=")[1];

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return passwords;
    }

    public static void overwritePassword(String newPassword){

        String[] passwords = getLastPasswords();
        try(FileWriter writer = new FileWriter
                (ConfigProvider.PASSWORD_HISTORY_FILE_PATH, false)) {
            writer.write("\nprevious " + passwords[1] +"\nactual " + newPassword);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
