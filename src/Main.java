import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String pathToDir, path, foldN;
    static String exest, name;

    public static void main(String[] args) throws IOException {
        //WindowSettings();
        System.out.println("Enter  your path to folder (The path must not have spaces)");

        Scanner sc = new Scanner(System.in);
        pathToDir = sc.next();

        Path checkPath = Paths.get(pathToDir);
        while (!Files.exists(checkPath)){
            System.out.println("Enter  your path to folder (The path must not have spaces)");
            pathToDir = sc.next();
            checkPath = Paths.get(pathToDir);
        }

        SearchFiles(pathToDir);
        System.out.println("Cleaning finished!");
    }
    public static void SearchFiles(String path) throws IOException {
        File dir = new File(path);
        if(dir.isDirectory()){
            for(File f : dir.listFiles()){
                if(f.isDirectory()){
                    String[] check = f.list();
                    if(check.length == 0){
                        f.delete();
                    }
                }else if(f.length() <= 1024){
                    f.delete();
                }else {
                    name = f.getName();
                    exest = name.substring(name.lastIndexOf('.') + 1);
                    Distrib(exest, f);
                }
            }
        }else {
            System.out.println("Данный путь не является каталогом");
        }
    }
    public static void Distrib(String s, File file) throws IOException {
        if(s.equals("jpg") || s.equals("jpeg") ||  s.equals("png")){
            foldN = "\\Photos";
        }
        else if(s.equals("mp3") || s.equals("wav") ||  s.equals("wma")){
            foldN = "\\Audios";
        }
        else if(s.equals("doc") || s.equals("docx") ||  s.equals("txt") || s.equals("odt")){
            foldN = "\\Texts";
        }
        else if(s.equals("ods") || s.equals("odp") ||  s.equals("xlsx") || s.equals("pptx")){
            foldN = "\\Tables And Presentations";
        }
        else if(s.equals("mp4") || s.equals("avi") ||  s.equals("wmv")){
            foldN = "\\Videos";
        }
        else if(s.equals("rar") || s.equals("zip")){
            foldN =  "\\Archives";
        }
        else {
            foldN = "\\Other Files";
        }
        path = pathToDir + foldN;
        Path pathP = Paths.get(path);
        if(!Files.exists(pathP)){
            new File(path).mkdir();
        }
        Files.copy(file.toPath(),pathP.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
        file.delete();

    }
}