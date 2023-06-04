package net.nonswag.shader;

import net.nonswag.shader.math.Vector2;
import net.nonswag.shader.math.Vector4;

public interface Paintable {
    Vector4 paint(Vector2 coordinate);

    Vector2 getResolution();
}
