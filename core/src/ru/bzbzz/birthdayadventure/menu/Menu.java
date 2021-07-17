package ru.bzbzz.birthdayadventure.menu;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.bzbzz.birthdayadventure.menu.objects.Cake;
import ru.bzbzz.birthdayadventure.menu.objects.StartButton;
import ru.bzbzz.birthdayadventure.menu.objects.balloons.BalloonManager;
import ru.bzbzz.birthdayadventure.utils.GdxUtils;

public class Menu extends InputAdapter implements ApplicationListener {
    public static final float WORLD_WIDTH = 12.8f;
    public static final float WORLD_HEIGHT = 7.2f;

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private TextureAtlas atlas;

    private BalloonManager balloons;
    private Cake cake;
    private Texture text;
    private StartButton start;

    private Texture background;
    private Music music;

    private float aspect;

    @Override
    public void create() {
        Gdx.input.setInputProcessor(this);
        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        batch = new SpriteBatch();
        atlas = new TextureAtlas(Gdx.files.internal("atlas/menu.atlas"));
        balloons = new BalloonManager(atlas);
        cake = new Cake(atlas);
        text = new Texture(Gdx.files.internal("text.png"));
        start = new StartButton(atlas);
        background = new Texture(Gdx.files.internal("evening.png"));
        music = Gdx.audio.newMusic(Gdx.files.internal("song.mp3"));
        music.setLooping(true);
        music.play();
        music.setVolume(1f);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        aspect = (float) height / width;
        System.out.println("aspect: " + aspect);
    }

    @Override
    public void render() {
        GdxUtils.clearScreen();

        update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        draw();

        batch.end();
    }

    private void update() {
        float delta = Gdx.graphics.getDeltaTime();
        balloons.update(delta);
        cake.update(delta);
    }

    private void draw() {
        batch.draw(background, 0, 0, WORLD_WIDTH, WORLD_HEIGHT);
        balloons.draw(batch);
        cake.draw(batch);
        batch.draw(text,  WORLD_WIDTH/2 - text.getWidth()/2*0.025f, WORLD_HEIGHT/10*6.3f, text.getWidth()*0.025f, text.getHeight()*0.025f);
        start.draw(batch);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        atlas.dispose();
        balloons.dispose();
        cake.dispose();
        text.dispose();
        start.dispose();
        background.dispose();
        music.dispose();
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return start.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return start.touchUp(screenX, screenY, pointer, button);
    }

}

