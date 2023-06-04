package net.nonswag.shader;

import net.nonswag.shader.math.Vector2;
import net.nonswag.shader.math.Vector4;

import javax.swing.*;
import java.awt.*;

import static net.nonswag.shader.math.Geometry.*;

public class Frame extends JFrame implements Paintable {

    public float time = 0;

    public static void main(String[] args) {
        var frame = new Frame();
        frame.setVisible(true);
        new Thread(() -> {
            while (true) {
                try {
                    frame.update(frame.getGraphics());
                    Thread.sleep(1);
                    frame.time += .1;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

    public Frame() {
        super("Shader");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public synchronized void update(Graphics graphics) {
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                var painted = paint(new Vector2(x, y));
                graphics.setColor(new Color(
                        Math.max(0, Math.min(1, painted.x)),
                        Math.max(0, Math.min(1, painted.y)),
                        Math.max(0, Math.min(1, painted.z)),
                        Math.max(0, Math.min(1, painted.w))
                ));
                //graphics.clearRect(x, y, 1, 1);
                graphics.fillRect(x, getHeight() - y, 1, 1);
                graphics.setColor(null);
            }
        }
        graphics.dispose();
    }

    @Override
    public synchronized Vector4 paint(Vector2 coordinate) {
        var uv = coordinate.multiply(2).subtract(getResolution()).divide(getResolution().y);

        var d = length(uv);
        d = (float) Math.sin(d * 8 + time) / 8;
        d = Math.abs(d);
        d = smoothStep(0, .1f, d);

        d = .02f / d;

        return new Vector4(d, d, d, 1f);
    }

    @Override
    public Vector2 getResolution() {
        return new Vector2(getWidth(), getHeight());
    }
}
