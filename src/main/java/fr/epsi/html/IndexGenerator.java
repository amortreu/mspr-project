package fr.epsi.html;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class IndexGenerator {

    public static void main(String[] args) {
        if(args.length == 0){
            System.err.println("Veulliez indiquer le chemin du fichier");
            System.exit(1);
            return;
        }

        Path file = Paths.get(args[0]);
        if(!file.toFile().exists()){
            System.err.println("Le fichier " + args[0] + "n'existe pas");
            System.exit(2);
            return;
        }

        try {
            System.out.println("<html><body><table><tbody>");
            List<String> lines = Files.readAllLines(file);

            for (String line : lines) {
                // System.out.println(line);
                System.out.println("<tr>");
                String[] array  = line.split(",");
                for (String a:array){
                    System.out.println("<td>");
                    System.out.println("<a href='"+a+".html'>"+a+"</a>");
                    System.out.println("</td>");
                }
                System.out.println("</tr>");
            }
            System.out.println("</tbody></table></body></html>");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
