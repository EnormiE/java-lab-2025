import java.util.Arrays;

public class SvgScene {
    private Polygon[] polygons = new Polygon[3];
    private int index = 0;

    public void addPolygon(Polygon polygon) {
//        if (index >= polygons.length) {
//            this.index = 0;
//            this.polygons[index] = polygon;
//            this.index++;
//        }
//        else {
//            this.polygons[index] = polygon;
//            this.index++;
//        }
        polygons[(index++) % 3] = polygon;
    }

    @Override
    public String toString() {
        return "SvgScene{" +
                "index=" + index +
                ", polygons=" + Arrays.toString(polygons) +
                '}';
    }
}