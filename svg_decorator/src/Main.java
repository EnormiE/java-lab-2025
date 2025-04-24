import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Polygon pentagon = new Polygon(new Vec2[]{
                new Vec2(0, 260),
                new Vec2(100, 460),
                new Vec2(300, 560),
                new Vec2(500, 460),
                new Vec2(600, 260)
        });

        Ellipse ellipse = new Ellipse(new Vec2(500, 700), 400, 100);
        SolidFillShapeDecorator filledPentagon = new SolidFillShapeDecorator(pentagon, "red");
        StrokeShapeDecorator strokeFilledPentagon = new StrokeShapeDecorator(filledPentagon, "blue", 5.0);

        SolidFillShapeDecorator filledEllipse = new SolidFillShapeDecorator(ellipse, "blue");
        StrokeShapeDecorator strokeFilledEllipse = new StrokeShapeDecorator(filledEllipse, "red", 5.0);


        SvgScene scene = new SvgScene();
        scene.addShape(strokeFilledPentagon);
        scene.addShape(strokeFilledEllipse);
        scene.save("result.svg");

    }
}
