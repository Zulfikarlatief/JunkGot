package Arkode.zword.GoBicycle.Control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Setting {
	
	public static Preferences prefs ;
	
	public static void loadSetting(){
		prefs = Gdx.app.getPreferences("Save Game");
	}
	
	
	
	
}
