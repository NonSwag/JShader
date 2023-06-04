package net.nonswag.shader.math;

public class Geometry {
    public static float step(float threshold, float value) {
        return value < threshold ? 0 : 1;
    }

    public static float smoothStep(float minimum, float maximum, float value) {
        var t = clamp((value - minimum) / (maximum - minimum), 0, 1);
        return t * t * (3 - 2 * t);

    }

    public static float clamp(float value, float minimum, float maximum) {
        return Math.max(minimum, Math.min(value, maximum));
    }
}
