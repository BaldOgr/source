package org.baldogre.labirint.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {
    Texture textureRegion;

    public Player() {
        textureRegion = new Texture(Gdx.files.internal("badlogic.jpg"));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, getX(), getY(), getWidth(), getHeight());
    }
}
