public class ShapeDecorator implements Shape{
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decortedShape) {
        this.decoratedShape = decortedShape;
    }

    @Override
    public String toSvg(String parameters) {
        return decoratedShape.toSvg(parameters);
    }
}
