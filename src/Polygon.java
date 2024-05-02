import java.util.Locale;

public class Polygon implements Shape {
    private Vec2[] points;
    public Polygon(Vec2[] points) {
        this.points = points;
    }
    public Polygon(Polygon polygon){
        this.points = new Vec2[polygon.points.length];
        System.arraycopy(polygon.points, 0, this.points, 0, polygon.points.length);
    }
    @Override
    public String toSvg(String params){
        StringBuilder sb = new StringBuilder();
        for(Vec2 i : points){
            sb.append(i.x)
                    .append(",")
                    .append(i.y)
                    .append(" ");
        }
        return String.format(Locale.ENGLISH, "<polygon points=\"%s\" %s/>",
        sb,params);
    }
    public static Polygon square(Segment segment){
        double centerX = (segment.getStartPoint().x + segment.getEndPoint().x)/2;
        double centerY = (segment.getStartPoint().y + segment.getEndPoint().y)/2;
        double dx = Math.abs(centerX - segment.getEndPoint().x);
        double dy = Math.abs(centerY - segment.getEndPoint().y);
        return new Polygon(new Vec2[]{
                new Vec2(centerX - dx, centerY + dy),
                new Vec2(centerX + dx, centerY + dy),
                new Vec2(centerX + dx, centerY - dy),
                new Vec2(centerX - dx, centerY - dy)}
                );
    }
}
