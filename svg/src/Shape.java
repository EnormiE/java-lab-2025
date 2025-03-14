public abstract class Shape {
    protected Style style;

    public Shape(Style style) {
        this.style = style;
    }

    public Shape() {
        style = new Style("none", "black", 1.0);
    }

    abstract String toSvg();
}
