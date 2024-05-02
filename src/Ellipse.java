import java.util.Locale;

public class Ellipse implements Shape{
    private Vec2 center;
    private double rx;
    private double ry;
    public Ellipse(Vec2 center, double rx, double ry) {
        this.center = center;
        this.rx = rx;
        this.ry = ry;
    }
    @Override
    public String toSvg(String params){
        return String.format(Locale.ENGLISH,  "<ellipse rx=\"%f\" ry=\"%f\" cx=\"%f\" cy=\"%f\" %s />",
                rx, ry, center.x, center.y,params);
    }
}
