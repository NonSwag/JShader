package net.nonswag.shader.math;

public class Vector3 extends Vector2 {
    public final float z;

    public Vector3(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Vector3 add(Vector3 vector) {
        return new Vector3(x + vector.x, y + vector.y, z + vector.z);
    }

    public Vector3 subtract(Vector3 vector) {
        return new Vector3(x - vector.x, y - vector.y, z - vector.z);
    }

    public Vector3 multiply(Vector3 vector) {
        return new Vector3(x * vector.x, y * vector.y, z * vector.z);
    }

    public Vector3 divide(Vector3 vector) {
        return new Vector3(x / vector.x, y / vector.y, z / vector.z);
    }

    public Vector3 max(Vector3 max) {
        return new Vector3(Math.max(x, max.x), Math.max(y, max.y), Math.max(z, max.z));
    }

    public float dot(Vector3 vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }
}
