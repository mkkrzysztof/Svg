import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class SvgScene {
    private ArrayList<Shape> polygons = new ArrayList<>();
    private ArrayList<String> defs = new ArrayList<>();
    private static int index = 0;
    private static SvgScene instance;
    private SvgScene(){};
    public static SvgScene getInstance(){
        if(instance == null){
            instance = new SvgScene();
        }
        return instance;
    }
    public void addPolygon(Shape polygon){
        this.polygons.add(polygon);
    }

    public int addDef(String def){
        this.defs.add(
                String.format(Locale.ENGLISH,def, ++index)
        );
        return index;
    }
    public void save(String path){
        StringBuilder sb = new StringBuilder();
        for(Shape i : polygons){
            sb.append(i.toSvg(""))
                    .append(" \n");
        }

        StringBuilder sb2 = new StringBuilder();
        for(String i : defs){
            sb2.append(i)
                    .append(" \n");
        }
        String save =  String.format(Locale.ENGLISH, "<!DOCTYPE html>\n<html>\n<body>\n" +
                "<svg height=\"600\" width=\"600\">\n" +
                "<defs>" +
                "%s" +
                "</defs>\n" +
                "%s" +
                "</svg>\n</body>\n</html>)",sb2.toString(),sb.toString());
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            bw.write(save);
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
