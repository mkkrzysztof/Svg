import java.util.Locale;

public class StrokeShapeDecorator extends ShapeDecorator{
    private String color;
    Double width;

    public StrokeShapeDecorator(Shape decoratedShape, String color, Double width) {
        super(decoratedShape);
        this.color = color;
        this.width = width;
    }
    @Override
    public String toSvg(String params){
        String f = String.format(Locale.ENGLISH, "stroke=\"%s\" stroke-width=\"%f\" %s", color, width, params);
        return decoratedShape.toSvg(f);
    }
}
