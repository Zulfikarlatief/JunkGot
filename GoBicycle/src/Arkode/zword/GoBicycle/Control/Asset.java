package Arkode.zword.GoBicycle.Control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Asset {
	public static TextureAtlas dummyAtlas;
	
	public static TextureAtlas dOther;
	public static TextureAtlas resultAtlas;
	public static TextureAtlas riverAtlas;
	public static TextureAtlas rewardAtlas;
	public static TextureAtlas infoAtlas;
	
	public static TextureAtlas bgAchieve;
	
	public static TextureAtlas logoAtlas;
	public static TextureAtlas mnBtnAtlas;
	public static TextureAtlas bgAtlas;

	//fix
	public static TextureAtlas charAtlas;
	public static TextureAtlas heroAtlas;
	public static TextureAtlas hScoreAtlas;
	public static TextureAtlas menuAtlas;
	public static TextureAtlas pauseAtlas;
	public static TextureAtlas scoringAtlas;
	
	
	
	public static TextureRegion player;
	public static TextureRegion river;
	public static TextureRegion stone;
	public static TextureRegion trash;
	
	public static Skin bSkin ; 

	
	public static BitmapFont scoreFont;
	public static BitmapFont numberFont;
	
	
	public static void loadSplash(){
		bgAtlas = new TextureAtlas(Gdx.files.internal("BgScreen.atlas"));
	}
	
	public static void load(){
		
		charAtlas = new TextureAtlas(Gdx.files.internal("atlas/charPack.atlas"));
		heroAtlas = new TextureAtlas(Gdx.files.internal("atlas/heroPack.atlas"));
		hScoreAtlas = new TextureAtlas(Gdx.files.internal("atlas/hScorePack.atlas"));
		menuAtlas = new TextureAtlas(Gdx.files.internal("atlas/menuPack.atlas"));
		pauseAtlas = new TextureAtlas(Gdx.files.internal("atlas/pausePack.atlas"));
		scoringAtlas = new TextureAtlas(Gdx.files.internal("atlas/resultPack.atlas"));
		
		
		logoAtlas = new TextureAtlas(Gdx.files.internal("arkodelogo.atlas"));
		dummyAtlas = new TextureAtlas(Gdx.files.internal("dummy.atlas"));
		dOther = new TextureAtlas(Gdx.files.internal("otherDummy.atlas"));
		resultAtlas = new TextureAtlas(Gdx.files.internal("resultScreen.atlas"));
		riverAtlas = new TextureAtlas(Gdx.files.internal("riverScreen.atlas"));
		rewardAtlas = new TextureAtlas(Gdx.files.internal("poster.atlas"));
		infoAtlas = new TextureAtlas(Gdx.files.internal("infoScreen.atlas"));
		
		mnBtnAtlas = new TextureAtlas(Gdx.files.internal("menuButton.atlas"));
		
		bgAchieve = new TextureAtlas(Gdx.files.internal("bgAchieve.atlas"));
		
		player = dummyAtlas.findRegion("H1");
		stone = dOther.findRegion("stone2");
		
		Texture texture2 = new Texture(Gdx.files.internal("number.png"));
		texture2.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		numberFont = new BitmapFont(Gdx.files.internal("number.fnt"), 
				new TextureRegion(texture2), false);
		
		Texture texture = new Texture(Gdx.files.internal("Gamefont.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		scoreFont = new BitmapFont(Gdx.files.internal("Gamefont.fnt"), 
				new TextureRegion(texture), false);
	}
	
	public static void dispose(){
		dummyAtlas.dispose();
		
		//fix
		charAtlas.dispose();
		heroAtlas.dispose();
		hScoreAtlas.dispose();
		menuAtlas.dispose();
		pauseAtlas.dispose();
		scoringAtlas.dispose();
		
		
		riverAtlas.dispose();
		rewardAtlas.dispose();
		infoAtlas.dispose();
		
		//font
		numberFont.dispose();
		scoreFont.dispose();
		
	}
}
