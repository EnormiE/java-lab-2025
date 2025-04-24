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

        SvgScene scene = new SvgScene();
        scene.addShape(pentagon);
        scene.addShape(ellipse);
        scene.save("result.svg");
    }
}
