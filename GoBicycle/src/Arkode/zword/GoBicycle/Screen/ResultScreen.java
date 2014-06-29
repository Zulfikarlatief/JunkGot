package Arkode.zword.GoBicycle.Screen;

import java.util.Arrays;

import Arkode.zword.GoBicycle.GoBicycle;
import Arkode.zword.GoBicycle.Actor.Result;
import Arkode.zword.GoBicycle.Control.Setting;
import Arkode.zword.GoBicycle.Control.SoundSetting;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Sort;

public class ResultScreen implements Screen , GestureListener{
	
	private GoBicycle game;
	
	private Stage stage;
	private Result result;
	
	private long tScore;
	
	
	public ResultScreen(GoBicycle game , float distance, int score) {
		// TODO Auto-generated constructor stub
		this.game = game;
		stage = new Stage();
		result = new Result(distance , score);
		
		tScore = (long) (distance*2 + score*10);
		
		stage.addActor(result);
		
		
		saveScore();
		
		
		if(score > Setting.prefs.getInteger("Score")){
			Setting.prefs.putInteger("Score", score); // save state jangan dilakukan disini (lambat)
		}
		
		if(distance > Setting.prefs.getFloat("Distance")){
			Setting.prefs.putFloat("Distance", distance); // save state jangan dilakukan disini (lambat)
		}
		
		Setting.prefs.flush();
		
	}
	
	private void saveScore(){
		long array[] = new long[6];
		
		array[0] = Setting.prefs.getLong("HighScore1");
		array[1] = Setting.prefs.getLong("HighScore2");
		array[2] = Setting.prefs.getLong("HighScore3");
		array[3] = Setting.prefs.getLong("HighScore4");
		array[4] = Setting.prefs.getLong("HighScore5");
	
		array[5] = tScore;

		Arrays.sort(array);
				
		Setting.prefs.putLong("HighScore1",array[5] ); 
		Setting.prefs.putLong("HighScore2",array[4] ); 
		Setting.prefs.putLong("HighScore3",array[3] ); 
		Setting.prefs.putLong("HighScore4",array[2] ); 
		Setting.prefs.putLong("HighScore5",array[1] ); 
		
		

	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
		if(Gdx.input.justTouched()){
			game.setScreen(new MenuScreen(game));
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
					game.setScreen(new MenuScreen(game));
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
		SoundSetting.menuBgm.setVolume(0f);
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		SoundSetting.menuBgm.setVolume(0.3f);

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
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
