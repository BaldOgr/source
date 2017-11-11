package org.baldogre.labirint.main_menu;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import org.baldogre.labirint.entity.Player;
import org.baldogre.labirint.entity.Wall;

public class MainMenuStage extends Stage {
    private final TiledMap map;
    TiledMapRenderer tiledMapRenderer;
    OrthographicCamera camera;
    Group wall;
    SpriteBatch batch;


    public MainMenuStage(SpriteBatch batch, OrthographicCamera camera, Player player) {
        super();
        this.batch = batch;
        this.camera = camera;
        wall = new Group();
        map = new TmxMapLoader().load("xml/levels/main_menu.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(map);
        MapLayer wallMap = map.getLayers().get("wall");
        for (MapObject obj : wallMap.getObjects()) {
            MapProperties properties = obj.getProperties();
            wall.addActor(new Wall((Float) properties.get("x"),
                    (Float) properties.get("y"),
                    (Float) properties.get("width"),
                    (Float) properties.get("height")));
        }
        MapProperties properties = map.getLayers().get("player").getObjects().get(0).getProperties();
        player.setPosition((Float) properties.get("x"), (Float) properties.get("y"));
        player.setSize((Float) properties.get("width"), (Float) properties.get("height"));
    }

    @Override
    public void draw() {
        super.draw();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
    }
}
