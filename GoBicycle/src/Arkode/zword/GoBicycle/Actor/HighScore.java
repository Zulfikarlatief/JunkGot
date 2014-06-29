package Arkode.zword.GoBicycle.Actor;

import Arkode.zword.GoBicycle.Control.Asset;
import Arkode.zword.GoBicycle.Control.Setting;
import Arkode.zword.GoBicycle.Control.SoundSetting;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class HighScore extends Table{
	
	public Text score1;
	public Text score2;
	public Text score3;
	public Text score4;
	public Text score5;
	
	private ButtonImage home;
	
	public boolean pause = false;

	public boolean menu = false;
	
	public HighScore() {
		// TODO Auto-generated constructor stub
		
		setClip(true);
		
		setBounds(0, 0, 480, 800); // set lebar dan panjang tempat
		
		home = new ButtonImage(240, 50, 80, 60 , Asset.infoAtlas.findRegion("home") , true){
			@Override
			public void afterTouch() {
				// TODO Auto-generated method stub
				super.afterTouch();
				SoundSetting.buttonSound.play();
				menu = true;
			}
		};
		
		addActor(home);
		home.show = true;
		
		LabelStyle ls = new LabelStyle(Asset.scoreFont, Color.WHITE); // new style text 
		score1 = new Text(Long.toString(Setting.prefs.getLong("HighScore1")), ls, 100f,getHeight() - 200f, getWidth(), 30f); // new score
		
		score2 = new Text(Long.toString(Setting.prefs.getLong("HighScore2")), ls, 100f,getHeight() - 300f, getWidth(), 30f); // new score

		score3 = new Text(Long.toString(Setting.prefs.getLong("HighScore3")), ls, 100f,getHeight() - 400f, getWidth(), 30f); // new score

		score4 = new Text(Long.toString(Setting.prefs.getLong("HighScore4")), ls, 100f,getHeight() - 500f, getWidth(), 30f); // new score

		score5 = new Text(Long.toString(Setting.prefs.getLong("HighScore5")), ls, 100f,getHeight() - 600f, getWidth(), 30f); // new score
		
		
		addActor(score1);
		addActor(score2);
		addActor(score3);
		addActor(score4);
		addActor(score5);
		
		if(Setting.prefs.getLong("HighScore1") != 0)
			score1.show = true;
		
		if(Setting.prefs.getLong("HighScore2") != 0)
			score2.show = true;
		
		if(Setting.prefs.getLong("HighScore3") != 0)
			score3.show = true;
		
		if(Setting.prefs.getLong("HighScore4") != 0)
			score4.show = true;
		
		if(Setting.prefs.getLong("HighScore5") != 0)
			score5.show = true;
		
		
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		if(!SoundSetting.menuBgm.isPlaying() && !pause)
			SoundSetting.menuBgm.play();

		super.act(delta);
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
		batch.draw(Asset.hScoreAtlas.findRegion("highscore"), 0, 0, 480, 800);
		super.draw(batch, parentAlpha);
	}
}
