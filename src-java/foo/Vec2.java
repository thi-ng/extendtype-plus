package foo;

public class Vec2 {

    public final double x,y;

    public Vec2() {
        this(0.0, 0.0);
    }

    public Vec2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vec2 addV2(Vec2 v) {
        return new Vec2(x + v.x, y + v.y);
    }

    public Vec2 addD(double n) {
        return new Vec2(x + n, y + n);
    }

    public Vec2 addV2V2(Vec2 a, Vec2 b) {
        return new Vec2(x + a.x + b.x, y + a.y + b.y);
    }

    public Vec2 addV2D(Vec2 a, double n) {
        return new Vec2(x + a.x + n, y + a.y + n);
    }

    public Vec2 addDD(double _x, double _y) {
        return new Vec2(x + _x, y + _y);
    }

    public String toString() {
        return "[" + x + " " + y + "]";
    }
}
