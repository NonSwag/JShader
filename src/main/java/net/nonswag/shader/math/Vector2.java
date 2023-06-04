package net.nonswag.shader.math;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Vector2 {
    public final float x;
    public final float y;

    public Vector2 add(Vector2 vector) {
        return new Vector2(x + vector.x, y + vector.y);
    }

    public Vector2 subtract(Vector2 vector) {
        return new Vector2(x - vector.x, y - vector.y);
    }

    public Vector2 subtract(float value) {
        return new Vector2(x - value, y - value);
    }

    public Vector2 multiply(Vector2 vector) {
        return new Vector2(x * vector.x, y * vector.y);
    }

    public Vector2 multiply(float value) {
        return new Vector2(x * value, y * value);
    }

    public Vector2 divide(Vector2 vector) {
        return new Vector2(x / vector.x, y / vector.y);
    }

    public Vector2 divide(float value) {
        return new Vector2(x / value, y / value);
    }

    public Vector2 max(Vector2 max) {
        return new Vector2(Math.max(x, max.x), Math.max(y, max.y));
    }

    public float dot(Vector2 vector) {
        return x * vector.x + y * vector.y;
    }
}
