package net.nonswag.shader;

import net.nonswag.shader.math.Vector2;
import net.nonswag.shader.math.Vector3;
import net.nonswag.shader.math.Vector4;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame implements Paintable {

    private static final float maxFrames = 10;
    public float time = 0;

    public static void main(String[] args) {
        var frame = new Frame();
        frame.setVisible(true);
        new Thread(() -> {
            var lastUpdate = System.currentTimeMillis();
            while (true) {
                long now = System.currentTimeMillis();
                if (now - lastUpdate < 1000f / maxFrames) continue;
                lastUpdate = now;
                frame.update(frame.getGraphics());
                frame.time += .1f;
            }
        }).start();
    }

    public Frame() {
        super("Shader");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        setUndecorated(true);
        pack();
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
    }

    @Override
    public void update(Graphics graphics) {
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y <= getHeight(); y++) {
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
    }

    @Override
    public Vector4 paint(Vector2 coordinate) {
        var uv = coordinate.multiply(2).subtract(getResolution()).divide(getResolution().y);
        var uv0 = uv;
        var finalColor = new Vector3(0, 0, 0);

        for (int i = 0; i < 4; i++) {

            uv = uv.multiply(1.5f).fract().subtract(.5f);

            var d = uv.length() * (float) Math.exp(-uv0.length());

            var col = palette(uv0.length() + time * .4f,
                    new Vector3(.5f, .5f, .5f),
                    new Vector3(.5f, .5f, .5f),
                    new Vector3(1f, 1f, 1f),
                    new Vector3(.263f, .416f, .557f)
            );

            d = (float) Math.sin(d * 8 + time) / 8;
            d = Math.abs(d);

            d = (float) Math.pow(.01 / d, 1.2);

            finalColor = finalColor.add(col.multiply(d));
        }

        return new Vector4(finalColor.x, finalColor.y, finalColor.z, 1f);
    }

    @Override
    public Vector3 palette(float value, Vector3 a, Vector3 b, Vector3 c, Vector3 d) {
        return a.add(b.multiply(c.multiply(value).add(d).multiply(6.28318f).cos()));
    }

    @Override
    public Vector2 getResolution() {
        return new Vector2(getWidth(), getHeight());
    }
}
