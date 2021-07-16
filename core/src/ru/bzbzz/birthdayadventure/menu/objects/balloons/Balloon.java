package ru.bzbzz.birthdayadventure.menu.objects.balloons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static ru.bzbzz.birthdayadventure.menu.Menu.WORLD_WIDTH;

public class Balloon extends Sprite {
    private static final float SCALE = 0.05f;
    private TextureRegion region;

    public Balloon(TextureRegion region) {
        super(region, 0, 0, region.getRegionWidth(), region.getRegionHeight());
        this.region = region;
    }

    public void draw(SpriteBatch batch, float x, float y, boolean fromRight) {
        if (fromRight) {
            batch.draw(region, getX() + WORLD_WIDTH - region.getRegionWidth() * SCALE - x, getY() + y, region.getRegionWidth() * SCALE, region.getRegionHeight() * SCALE);
            return;
        }
        batch.draw(region, getX() + x, getY() + y, region.getRegionWidth() * SCALE, region.getRegionHeight() * SCALE);
    }

    public void draw(SpriteBatch batch, float x, float y) {
        draw(batch, x, y, false);
    }
}
