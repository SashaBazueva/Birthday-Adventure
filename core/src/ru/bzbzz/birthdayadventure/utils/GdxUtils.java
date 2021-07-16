package ru.bzbzz.birthdayadventure.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

public class GdxUtils {

    private GdxUtils() {
    }

    public static void clearScreen() {
        clearScreen(Color.BLACK);
    }

    public static void clearScreen(Color color) {
        Gdx.gl.glClearColor(color.r, color.g, color.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public static void clearScreen(float r, float g, float b) {
        clearScreen(r, g, b, 1);
    }

    public static void clearScreen(float r, float g, float b, float alpha) {
        Gdx.gl.glClearColor(r, g, b, alpha);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
