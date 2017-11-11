package org.baldogre.labirint.entity;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class Wall extends Actor {

    public Wall(float x, float y, float width, float height) {
        this.setBounds(x, y, width, height);
    }
}
