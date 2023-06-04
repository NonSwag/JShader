package net.nonswag.shader;

import net.nonswag.shader.math.Vector2;
import net.nonswag.shader.math.Vector3;
import net.nonswag.shader.math.Vector4;

public interface Paintable {
    Vector4 paint(Vector2 coordinate);

    Vector3 palette(float value, Vector3 a, Vector3 b, Vector3 c, Vector3 d);

    Vector2 getResolution();
}
