import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        File[] directory = {new File("E://Games/src"),
                new File("E://Games/res"),
                new File("E://Games/savegames"),
                new File("E://Games/temp"),
                new File("E://Games/src/main"),
                new File("E://Games/src/test"),
                new File("E://Games/temp/drawables"),
                new File("E://Games/temp/vectors"),
                new File("E://Games/temp/icons")};

        File[] newFile = {new File("E://Games/src/main/Main.java"),
                new File("E://Games/src/main/Utils.java")};

        File logFile = new File("E://Games/temp/temp.txt");

        for (File dir : directory)
            if (dir.mkdir())
                log.append("Create directory ").append(dir.getPath()).append(" success\n");
            else
                log.append("Create directory ").append(dir.getPath()).append(" fail\n");

        try {
            for (File file : newFile)

                if (file.createNewFile())
                    log.append("Create file ").append(file.getPath()).append(" success\n");
                else
                    log.append("Create file ").append(file.getPath()).append(" fail\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            if (logFile.createNewFile())
                log.append("Create file ").append(logFile.getPath()).append(" success\n");
            else
                log.append("Create file ").append(logFile.getPath()).append(" fail\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fos = new FileWriter("E://Games/temp/temp.txt")) {
            if (logFile.canWrite()) {
                fos.write(String.valueOf(log));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}