import java.util.Locale;

public class Style {
    public final String fillColor;
    public final String strokeColor;
    public final Double strokeWidth;

    public Style(String fillColor, String strokeColor, Double strokeWidth) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }

    public String toSvg() {
//        style="fill:red;stroke:black;stroke-width:3"
        return String.format(
                Locale.ENGLISH,
                "fill:%s;stroke:%s;stroke-width:%f",
                fillColor,
                strokeColor,
                strokeWidth);
    }
}
