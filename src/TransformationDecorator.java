import java.util.Locale;

public class TransformationDecorator extends ShapeDecorator{
    private String transform;
    public TransformationDecorator(Shape shape, String transform){
        super(shape);
        this.transform = transform;
    }

    public static class Builder{
        String transform;
        public Builder(){
            this.transform = "";
        }
        public Builder translate(Vec2 vec2){
            this.transform += String.format(Locale.ENGLISH," translate(%f %f)", vec2.x,vec2.y);
            return this;
        }
        public Builder rotate(double angle){
            this.transform += String.format(Locale.ENGLISH," rotate(%f)", angle);
            return this;
        }
        public Builder scale(Vec2 vec2){
            this.transform += String.format(Locale.ENGLISH," scale(%f, %f)", vec2.x,vec2.y);
            return this;
        }
        public TransformationDecorator build(Shape shape){
            return new TransformationDecorator(shape,transform);
        }
    }

    @Override
    public String toSvg(String params){
        return super.toSvg(String.format("%s transform=\"%s\"", params, this.transform));
    }
}
