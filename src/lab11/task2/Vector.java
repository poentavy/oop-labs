package lab11.task2;

public class Vector implements Summable {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Vector vector) {
        this.x = vector.x;
        this.y = vector.y;
        this.z = vector.z;
    }

    public Vector() {
        this(0d, 0d, 0d);
    }

    @Override
    public void addValue(Summable value) {
        Vector vector = new Vector((Vector) value);
        this.x += vector.x;
        this.y += vector.y;
        this.z += vector.z;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
