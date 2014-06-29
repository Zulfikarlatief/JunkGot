package Arkode.zword.GoBicycle.Control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundSetting {
	public static Music gameBgm;
	public static Music menuBgm;
	
	public static Sound buttonSound;
	public static Sound crashSound;
	public static Sound trashSound;
	public static Sound scoreSound;

	public static void loadSound(){
		gameBgm = Gdx.audio.newMusic(Gdx.files.internal("audio/GameBgSound.mp3"));
		menuBgm = Gdx.audio.newMusic(Gdx.files.internal("audio/MenuBgSound.mp3"));
		buttonSound = Gdx.audio.newSound(Gdx.files.internal("audio/buttonSound.mp3"));
		crashSound = Gdx.audio.newSound(Gdx.files.internal("audio/gameover.wav"));
		trashSound = Gdx.audio.newSound(Gdx.files.internal("audio/sampahSound.wav"));
		scoreSound = Gdx.audio.newSound(Gdx.files.internal("audio/score.mp3"));
	}
	
	public static void dispose(){
		gameBgm.dispose();
		menuBgm.dispose();
		
		buttonSound.dispose();
		crashSound.dispose();
		trashSound.dispose();
		scoreSound.dispose();
	}
}
