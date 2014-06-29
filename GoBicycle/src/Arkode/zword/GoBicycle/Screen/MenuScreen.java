package Arkode.zword.GoBicycle.Screen;

import Arkode.zword.GoBicycle.GoBicycle;
import Arkode.zword.GoBicycle.Actor.Menu;
import Arkode.zword.GoBicycle.Control.SoundSetting;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MenuScreen implements Screen , GestureListener{
	
	private GoBicycle game;
	
	private Stage stage;
	private Menu menu;
	
	public MenuScreen(GoBicycle game) {
		// TODO Auto-generated constructor stub
		this.game = game;
		stage = new Stage();
		menu = new Menu();
		stage.addActor(menu);
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
		
		if(menu.isStart){
			game.setScreen(new GameScreen(game));
		}else if (menu.isAchieve) {
			game.setScreen(new AchievementScreen(game));
		}else if (menu.isSetting) {
			game.setScreen(new InfoScreen(game));			
		}else if (menu.isScore) {
			game.setScreen(new HighScoreScreen(game));			
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		stage.setViewport(GoBicycle.WIDTH, GoBicycle.HEIGHT, true);
		stage.getCamera().translate(-stage.getGutterWidth(), -stage.getGutterHeight(), 0);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		InputMultiplexer plex = new InputMultiplexer();
		plex.addProcessor(new GestureDetector(this){
			@Override
			public boolean keyDown(int keycode) {
				// TODO Auto-generated method stub
				if(keycode == Keys.BACK){
//					Gdx.app.exit();
					menu.quit = true;
				}
				
				return super.keyDown(keycode);
			}
		});
		
		Gdx.input.setInputProcessor(plex);
		Gdx.input.setCatchBackKey(true);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
    	Gdx.input.setInputProcessor(null);

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		menu.pause = true;
		SoundSetting.menuBgm.setVolume(0f);

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		menu.pause = false;
		SoundSetting.menuBgm.setVolume(0.3f);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		System.out.println("MenuScreen dispose");

	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

}
