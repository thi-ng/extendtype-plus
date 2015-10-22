package foo;

import clojure.lang.IObj;
import clojure.lang.IPersistentMap;

public class Vec2 implements IObj {

    public final double x,y;
    public final IPersistentMap meta;

    public Vec2() {
        this(0.0, 0.0, null);
    }

    public Vec2(double x, double y) {
        this(x, y, null);
    }

    public Vec2(double x, double y, IPersistentMap meta) {
        this.x = x;
        this.y = y;
        this.meta = meta;
    }

    public Vec2 addV2(Vec2 v) {
        return new Vec2(x + v.x, y + v.y, meta);
    }

    public Vec2 addD(double n) {
        return new Vec2(x + n, y + n, meta);
    }

    public Vec2 addV2V2(Vec2 a, Vec2 b) {
        return new Vec2(x + a.x + b.x, y + a.y + b.y, meta);
    }

    public Vec2 addV2D(Vec2 a, double n) {
        return new Vec2(x + a.x + n, y + a.y + n, meta);
    }

    public Vec2 addDD(double _x, double _y) {
        return new Vec2(x + _x, y + _y, meta);
    }

    public String toString() {
        return "[" + x + " " + y + "]";
    }

    public IPersistentMap meta() {
        return meta;
    }

    public IObj withMeta(IPersistentMap meta) {
        return new Vec2(x, y, meta);
    }
}
