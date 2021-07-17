package ru.bzbzz.birthdayadventure.menu.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

import static ru.bzbzz.birthdayadventure.menu.Menu.WORLD_HEIGHT;
import static ru.bzbzz.birthdayadventure.menu.Menu.WORLD_WIDTH;

public class StartButton {
    private static final float SCALE = 0.03f;

    private ArrayList<Sprite> btn;
    private Rectangle bound;
    private Sprite up;
    private Sprite down;
    private byte frame;

    private float scX;
    private float scY;

    private boolean isPressed;

    public StartButton(TextureAtlas atlas) {

        up = new Sprite(atlas.findRegion("btn1"),
                0, 0,
                atlas.findRegion("btn1").getRegionWidth(),
                atlas.findRegion("btn1").getRegionHeight());
        down = new Sprite(atlas.findRegion("btn2"),
                0, 0,
                atlas.findRegion("btn2").getRegionWidth(),
                atlas.findRegion("btn2").getRegionHeight());
        btn = new ArrayList<>(2);

        btn.add(up);
        btn.add(down);

        bound = new Rectangle(
                WORLD_WIDTH / 2 - btn.get(frame).getWidth() / 2 * SCALE,
                0.2f,
                btn.get(frame).getWidth() * SCALE,
                btn.get(frame).getHeight() * SCALE);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(btn.get(frame),
                WORLD_WIDTH / 2 - btn.get(frame).getWidth() / 2 * SCALE,
                0.2f, btn.get(frame).getWidth() * SCALE,
                btn.get(frame).getHeight() * SCALE);
    }

    public void dispose() {
        btn.clear();
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        scX = WORLD_WIDTH / Gdx.graphics.getWidth() * screenX;
        scY = WORLD_HEIGHT - WORLD_HEIGHT / Gdx.graphics.getHeight() * screenY;
        if (bound.contains(scX, scY)) {
            frame = 1;
            isPressed = true;
            return true;
        }
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        scX = WORLD_WIDTH / Gdx.graphics.getWidth() * screenX;
        scY = WORLD_HEIGHT - WORLD_HEIGHT / Gdx.graphics.getHeight() * screenY;
        if (bound.contains(scX, scY) && isPressed) {
            frame = 0;
            isPressed = false;
            return true;
        }
        if (!bound.contains(scX, scY)){
            frame = 0;
        }
        return false;
    }
}
