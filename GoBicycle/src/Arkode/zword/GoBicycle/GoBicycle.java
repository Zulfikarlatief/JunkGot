package Arkode.zword.GoBicycle;

import Arkode.zword.GoBicycle.Control.Asset;
import Arkode.zword.GoBicycle.Control.Setting;
import Arkode.zword.GoBicycle.Control.SoundSetting;
import Arkode.zword.GoBicycle.Screen.AchievementScreen;
import Arkode.zword.GoBicycle.Screen.GameScreen;
import Arkode.zword.GoBicycle.Screen.InfoScreen;
import Arkode.zword.GoBicycle.Screen.MenuScreen;
import Arkode.zword.GoBicycle.Screen.SplashScreen;

import com.badlogic.gdx.Game;



public class GoBicycle extends Game {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	private GameScreen gameScreen;
	private SplashScreen splashScreen;
	private MenuScreen menuScreen;
	private AchievementScreen achievementScreen;
	private InfoScreen infoScreen;	
	
	@Override
	public void create() {
		// TODO Auto-generated method stub


		Asset.load();
		
		Asset.loadSplash();
		SoundSetting.loadSound();
		
		Setting.loadSetting();
		
//		gameScreen = new GameScreen(this);
//		menuScreen = new MenuScreen(this);
		splashScreen = new SplashScreen(this);
//		achievementScreen = new AchievementScreen(this);	
//		infoScreen = new InfoScreen(this);
		
		setScreen(splashScreen);
//		setScreen(menuScreen);
//		setScreen(gameScreen);
//		setScreen(achievementScreen);
//		setScreen(infoScreen);
	}
	
	public void dispose(){
		System.out.println("GoBicycle dispose");
		
		Asset.dispose();
		SoundSetting.dispose();
		
//		menuScreen.dispose();
//		gameScreen.dispose();
		splashScreen.dispose();
//		achievementScreen.dispose();
//		infoScreen.dispose();
		
	}
}
