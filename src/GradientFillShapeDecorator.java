import java.util.Arrays;
import java.util.Locale;
public class GradientFillShapeDecorator extends ShapeDecorator {
    private record Stop(double offset, String color) {}
    private static int index;
    private Stop[] stops;
    private GradientFillShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }


    public static class Builder {
        private Stop[] stops = new Stop[0];
        private Shape shape;

        public Builder setShape(Shape shape) {
            this.shape = shape;
            return this;
        }

        public Builder addStop(double offset, String color) {
            stops = Arrays.copyOf(stops, stops.length + 1);
            stops[stops.length - 1] = new Stop(offset, color);
            return this;
        }

        public GradientFillShapeDecorator build() {
            GradientFillShapeDecorator result = new GradientFillShapeDecorator(shape);
            result.stops = this.stops;
            return result;
        }
    }

    private int addDefs() {
        SvgScene scene = SvgScene.getInstance();
        String result = "\t<linearGradient id=\"g%d\" >\n";
        for(var stop : stops)
            result += String.format(Locale.ENGLISH, "\t\t<stop offset=\"%f\" style=\"stop-color:%s\" />\n",
                    stop.offset,
                    stop.color);
        result += "\t</linearGradient>";
        index = scene.addDef(result);
        return index++;
    }

    @Override
    public String toSvg(String parameters) {
        int index = addDefs();
        return decoratedShape.toSvg(parameters + String.format("fill=\"url(#g%d)\" ", index));
    }
}