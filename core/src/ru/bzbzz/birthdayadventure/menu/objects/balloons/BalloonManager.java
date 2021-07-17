package ru.bzbzz.birthdayadventure.menu.objects.balloons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.ArrayList;

public class BalloonManager {
    private static final float MOTION = 0.2f;
    private static final float TIMER = 1.3f;


    private Balloon blue;
    private Balloon green;
    private Balloon lightBlue;
    private Balloon pink;
    private Balloon purple;
    private Balloon red;

    private ArrayList<Sprite> up;
    private ArrayList<Sprite> upToMiddle;
    private ArrayList<Sprite> downToMiddle;
    private ArrayList<Sprite> down;

    private float time;

    public BalloonManager(TextureAtlas atlas) {

        up = new ArrayList<>(3);
        upToMiddle = new ArrayList<>(6);
        downToMiddle = new ArrayList<>(6);
        down = new ArrayList<>(3);

        blue = new Balloon(atlas.findRegion("blue"));
        green = new Balloon(atlas.findRegion("green"));
        lightBlue = new Balloon(atlas.findRegion("light_blue"));
        pink = new Balloon(atlas.findRegion("pink"));
        purple = new Balloon(atlas.findRegion("purple"));
        red = new Balloon(atlas.findRegion("red"));

        up.add(red);
        up.add(pink);
        up.add(purple);
        up.add(blue);
        up.add(green);
        up.add(lightBlue);
    }

    public void draw(SpriteBatch batch) {
        green.draw(batch, 0.2f, 1.3f, true);
        blue.draw(batch, 1.9f, 3.4f);
        pink.draw(batch, 2.2f, 0.5f);
        purple.draw(batch, 1.7f, 3.0f, true);
        lightBlue.draw(batch, 2f, 0.3f, true);
        red.draw(batch, 0.3f, 1.6f);
    }

    public void update(float delta) {
        time += delta;
        if (time > TIMER) {
            time = 0;
            for (int i = 0; i < up.size(); i++) {
                Sprite ball = up.get(i);
                ball.setY(ball.getY() + MOTION);
                upToMiddle.add(ball);
                up.remove(ball);
            }

            for (int i = 0; i < upToMiddle.size(); i++) {
                Sprite ball = upToMiddle.get(i);
                ball.setY(ball.getY() - MOTION);
                upToMiddle.remove(ball);
                down.add(ball);
            }

            for (int i = 0; i < downToMiddle.size(); i++) {
                Sprite ball = downToMiddle.get(i);
                ball.setY(ball.getY() + MOTION);
                downToMiddle.remove(ball);
                up.add(ball);
            }

            for (int i = 0; i < down.size(); i++) {
                Sprite ball = down.get(i);
                ball.setY(ball.getY() - MOTION);
                downToMiddle.add(ball);
                down.remove(ball);
            }
        }

    }

    public void dispose() {
        up.clear();
        upToMiddle.clear();
        downToMiddle.clear();
        down.clear();
    }

}
