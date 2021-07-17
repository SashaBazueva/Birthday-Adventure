package ru.bzbzz.birthdayadventure.menu.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.ArrayList;

import static ru.bzbzz.birthdayadventure.menu.Menu.WORLD_WIDTH;

public class Cake {
    private static final float SCALE = 0.04f;
    private static final float TIMER = 0.3f;

    private ArrayList<Sprite> cakeUp;
    private Sprite up1;
    private Sprite up2;
    private Sprite up3;
    private Sprite up4;
    private Sprite down;

    private byte frame;
    private float time;

    public Cake(TextureAtlas atlas) {
        up1 = new Sprite(atlas.findRegion("cake_up1"),
                0, 0,
                atlas.findRegion("cake_up1").getRegionWidth(),
                atlas.findRegion("cake_up1").getRegionHeight());
        up2 = new Sprite(atlas.findRegion("cake_up2"),
                0, 0,
                atlas.findRegion("cake_up2").getRegionWidth(),
                atlas.findRegion("cake_up2").getRegionHeight());
        up3 = new Sprite(atlas.findRegion("cake_up3"),
                0, 0,
                atlas.findRegion("cake_up3").getRegionWidth(),
                atlas.findRegion("cake_up3").getRegionHeight());
        up4 = new Sprite(atlas.findRegion("cake_up4"),
                0, 0,
                atlas.findRegion("cake_up4").getRegionWidth(),
                atlas.findRegion("cake_up4").getRegionHeight());

        down = new Sprite(atlas.findRegion("cake_down"),
                0, 0,
                atlas.findRegion("cake_down").getRegionWidth(),
                atlas.findRegion("cake_down").getRegionHeight());

        cakeUp = new ArrayList<>();

        cakeUp.add(up1);
        cakeUp.add(up2);
        cakeUp.add(up3);
        cakeUp.add(up4);
    }

    public void update(float delta) {
        time += delta;
        if (time > TIMER) {
            time = 0;
            frame++;
            if (frame > 3) {
                frame = 0;
            }
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(down, WORLD_WIDTH / 2 - down.getWidth() / 2 * SCALE, 1f, down.getWidth() * SCALE, down.getHeight() * SCALE);
        batch.draw(cakeUp.get(frame), WORLD_WIDTH / 2 - down.getWidth() / 2 * SCALE + down.getWidth() / 5.5f * SCALE,  0.5f + down.getHeight() / 4 * SCALE * 3.7f, cakeUp.get(frame).getWidth() * SCALE, cakeUp.get(frame).getHeight() * SCALE);
    }

    public void dispose() {
        cakeUp.clear();
    }
}
