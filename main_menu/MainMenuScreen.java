package org.baldogre.labirint.main_menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import org.baldogre.labirint.LabirintGame;
import org.baldogre.labirint.entity.Player;

public class MainMenuScreen implements Screen {
    LabirintGame game;
    Stage stage;
    OrthographicCamera camera;
    Player player;
    boolean boom;
    float boomLength;

    public MainMenuScreen(final LabirintGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());
        player = new Player();
        player.setHeight(10);
        player.setWidth(10);
        stage = new MainMenuStage(game.getBatch(), camera, player);
        System.out.println("MainMenuScreen.show()");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        stage.draw();
        game.getBatch().begin();
//        game.getFont().draw(game.getBatch(), "Tima Pidor!", Gdx.app.getGraphics().getWidth() / 2, Gdx.app.getGraphics().getHeight() / 2);
        player.draw(game.getBatch(), 0);
        game.getBatch().end();
//        System.out.println("MainMenuScreen.render()");
        handleInput();
        if (boom){
            if (boomLength > 0 ){
                camera.translate((float) (Math.random() % 1.0f), (float) (Math.random()% 1.0f));
                boomLength -= delta;
            } else {
                boom = false;
            }
        }
    }

    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.setX(player.getX() - 1);
            camera.translate(-1, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.setX(player.getX() + 1);
            camera.translate(1, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.setY(player.getY() + 1);
            camera.translate(0,1, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.setY(player.getY() - 1);
            camera.translate(0,-1, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            if (!boom){
                boom = true;
                boomLength = 5f;
            }
        }
//        if (player.getX() - 200 > camera.position.x) {
//            camera.translate(-0.5f, 0, 0);
//            Gdx.app.log("position right", player.getX() + "/" + camera.position.x + "\n" + player.getWidth());
//        }
//        if (player.getX() + 200 + player.getWidth() < camera.position.x) {
//            camera.translate(0.5f, 0, 0);
//            Gdx.app.log("position left", player.getX() + "/" + camera.position.x + "\n" + player.getWidth());
//        }
//        if (player.getY() - 100 < camera.position.y) {
//            camera.translate(0, 0.5f, 0);
//            Gdx.app.log("position up", player.getY() + "/" + camera.position.y);
//        }
//        if (player.getY() + 100 + player.getHeight() > camera.position.y) {
//            camera.translate(0, -0.5f, 0);
//            Gdx.app.log("position down", player.getY() + "/" + camera.position.y);
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.E)){
//            camera.rotate(1);
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.Q)){
//            camera.rotate(-1);
//        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
