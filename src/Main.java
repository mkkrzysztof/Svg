public class Main {
    public static void main(String[] args) {
//        Segment line = new Segment(new Vec2(100 ,100), new Vec2(200, 200));
//        Segment line2 = new Segment(new Vec2(100, 200),new Vec2(200,100));
//        Vec2 point = new Vec2(300,300);
//        Style style = new Style("lime","green",2);
//        Polygon polygonFirst = new Polygon(new Vec2[]{
//                new Vec2(10,100),
//                new Vec2(110,20),
//                new Vec2(80,10)});
//        SolidFilledPolygon polygonSecond = new SolidFilledPolygon(new Vec2[]{
//                new Vec2(400,500),
//                new Vec2(350, 512),
//                new Vec2(100,500)},
//                "red");
//        Polygon polygonThird = Polygon.square(new Segment(
//                new Vec2(100,200),
//                new Vec2(200,100))
//                );
//        Shape ellipse = new Ellipse(point,50,80);

        SvgScene scene = SvgScene.getInstance();

        Shape shapeOne = new Ellipse(new Vec2(150,150),50,60);
        shapeOne = new SolidFillShapeDecorator(shapeOne,"red");
        shapeOne = new DropShadowDecorator(shapeOne);

        TransformationDecorator.Builder builder = new TransformationDecorator.Builder();
        Shape s = builder
                .rotate(45)
                .scale(new Vec2(0.8,0.6))
                .translate(new Vec2(20,-20))
                .build(new Ellipse(new Vec2(150,150),30,50));

        TransformationDecorator.Builder builder2 = new TransformationDecorator.Builder();
        Shape shape = builder2
                .rotate(45)
                .scale(new Vec2(0.8,0.6))
                .translate(new Vec2(-20,-20))
                .build(new Ellipse(new Vec2(150,150),30,50));

        GradientFillShapeDecorator.Builder bd = new GradientFillShapeDecorator.Builder();
        Shape s2 = bd
                .setShape(s)
                .addStop(0.5,"red")
                .addStop(0.8,"pink")
                .build();

        GradientFillShapeDecorator.Builder bd2 = new GradientFillShapeDecorator.Builder();
        Shape s3 = bd2
                .setShape(shape)
                .addStop(0.2,"green")
                .addStop(0.9,"lime")
                .build();


        scene.addPolygon(shapeOne);
        scene.addPolygon(s2);
        scene.addPolygon(s3);
        scene.save("polys.html");

//        System.out.println(line.toSvg());
//        for(Segment i : Segment.perpendicularSegment(line,point,10)) {
//            System.out.println(i.toSvg());
//        }

    }
}