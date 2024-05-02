import java.util.Locale;

public class Segment {
    private Vec2 startPoint;
    private Vec2 endPoint;

    public Segment(Vec2 startPoint, Vec2 endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Vec2 getStartPoint() {
        return startPoint;
    }
    public Vec2 getEndPoint() {
        return endPoint;
    }

    public double length() {
        return Math.hypot(endPoint.x - startPoint.x, endPoint.y - startPoint.y);
    }

    public String toSvg(){
        return String.format(Locale.ENGLISH," <line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:black;stroke-width:1\"/>"
                ,startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }
    public String toSvg(Style style){
        return String.format(Locale.ENGLISH," <line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" %s/>"
                ,startPoint.x, startPoint.y, endPoint.x, endPoint.y, style.toSvg());
    }
    static Segment[] perpendicularSegment(Segment segment, Vec2 point){
        double dx = segment.getEndPoint().x - segment.getStartPoint().x;
        double dy = segment.getEndPoint().y - segment.getStartPoint().y;
        return new Segment[]{
                new Segment(point, new Vec2(point.x + dx,point.y - dy)),
                new Segment(point, new Vec2(point.x - dx,point.y + dy))};
    }

    static Segment[] perpendicularSegment(Segment segment, Vec2 point, double length){
        double dx = segment.getEndPoint().x - segment.getStartPoint().x < 0 ? -1 : 1;
        double dy = segment.getEndPoint().y - segment.getStartPoint().y < 0 ? -1 : 1;
        return new Segment[]{
                new Segment(point, new Vec2(point.x + dx * length,point.y - dy * length)),
                new Segment(point, new Vec2(point.x - dx * length,point.y + dy * length))};
    }
}