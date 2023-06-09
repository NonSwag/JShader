package net.nonswag.shader.math;

public class Vector4 extends Vector3 {
    public final float w;

    public Vector4(float x, float y, float z, float w) {
        super(x, y, z);
        this.w = w;
    }

    public Vector4 add(Vector4 vector) {
        return new Vector4(x + vector.x, y + vector.y, z + vector.z, w + vector.w);
    }

    public Vector4 subtract(Vector4 vector) {
        return new Vector4(x - vector.x, y - vector.y, z - vector.z, w - vector.w);
    }

    public Vector4 multiply(Vector4 vector) {
        return new Vector4(x * vector.x, y * vector.y, z * vector.z, w * vector.w);
    }

    public Vector4 divide(Vector4 vector) {
        return new Vector4(x / vector.x, y / vector.y, z / vector.z, w / vector.w);
    }

    public Vector4 max(Vector4 max) {
        return new Vector4(Math.max(x, max.x), Math.max(y, max.y), Math.max(z, max.z), Math.max(w, max.w));
    }

    public float dot(Vector4 vector) {
        return x * vector.x + y * vector.y + z * vector.z + w * vector.w;
    }

    @Override
    public Vector4 cos() {
        return new Vector4(
                (float) Math.cos(x),
                (float) Math.cos(y),
                (float) Math.cos(z),
                (float) Math.cos(w)
        );
    }

    @Override
    public Vector4 fract() {
        return new Vector4(
                x - (float) Math.floor(x),
                y - (float) Math.floor(y),
                z - (float) Math.floor(z),
                w - (float) Math.floor(w)
        );
    }
}
