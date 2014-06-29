package Arkode.zword.GoBicycle.Actor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;

import java.util.Iterator;


import Arkode.zword.GoBicycle.GoBicycle;
import Arkode.zword.GoBicycle.Control.Asset;
import Arkode.zword.GoBicycle.Control.Setting;
import Arkode.zword.GoBicycle.Control.SoundSetting;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;


public class City extends Table {
	public CityScroll bgRiver1;
	public CityScroll bgRiver2;
	public CityScroll bgRiver3;
	public CityScroll bgRiver4;
	public CityScroll bgRiver5;
	
	public BikeActor playerActor;
	
	
	private Array<CityScroll> backgrounds;
	private Array<EnemyCar> enemyCars;
	private Array<Trash> trashs;
	
	public boolean out = false;
	public boolean result = false;
	public boolean retry=false;
	public boolean menu = false;
	public boolean pause = false;
	public boolean crash = false;
	
	private float lastCarTime = 0;
	private float lastTrashTime = 0;
	
	private float afterCrash = 0;
	public float timeStart = 0;
	private float distance = 0;
	
	
	public final float lane2 = 390;
	public final float lane1 = 240; // 3 line
	public final float lane0 = 90;
	
	public final float lane4 = 165;	// 2 line
	public final float lane5 = 315;
	
	private float speed = 400;
	
	public int counter = 0;
	
	private Text score;
	
	public ButtonImage menuButton;

	public ButtonImage resumeButton;	

	public City(){
		
		
		resumeButton = new ButtonImage(280, 300, 160, 70 , Asset.pauseAtlas.findRegion("resume") , true){
			@Override
			public void afterTouch() {
				// TODO Auto-generated method stub
			
				super.afterTouch();
				resume();
			}
		};
		
		menuButton = new ButtonImage(200, 500, 160, 70 , Asset.pauseAtlas.findRegion("home") , true){
			@Override
			public void afterTouch() {
				// TODO Auto-generated method stub
				super.afterTouch();
				menu = true;
				SoundSetting.gameBgm.stop();
			}
		};
		
		
		
		setBounds(0, 0, 480, 800); // set lebar dan panjang tempat
		setClip(true);
		bgRiver1 = new CityScroll(getWidth(), getHeight(), 0 ,0 , speed , 1 , 1); // new baground berjalan
		bgRiver2 = new CityScroll(getWidth(), getHeight(), 0 ,800 , speed , 2 , 2);
		bgRiver3 = new CityScroll(getWidth(), getHeight(), 0 ,1600 , speed , 1 , 3);
		bgRiver4 = new CityScroll(getWidth(), getHeight(), 0 ,2400 , speed , 2 , 4);
		bgRiver5 = new CityScroll(getWidth(), getHeight(), 0 ,2400 , speed , 2 , 5);
		
		addActor(bgRiver1);
		addActor(bgRiver2);
		addActor(bgRiver3);
		addActor(bgRiver4);
		addActor(bgRiver5);
		
		addActor(menuButton);
		addActor(resumeButton);
	
		playerActor = new BikeActor(this); // new player
		playerActor.show = true;
		
		addActor(playerActor);
		enemyCars = new Array<EnemyCar>(); // new array enemy
		trashs = new Array<Trash>(); // new array point
		LabelStyle ls = new LabelStyle(Asset.numberFont, Color.YELLOW); // new style text 
		
		score = new Text(Integer.toString(counter), ls, 80f,getHeight() - 50f, getWidth(), 30f); // new score
		addActor(score);
		score.show  = true;
		
		playerActor.moveToPosPlay(); // player move to playing position in the begining 
		SoundSetting.gameBgm.play();
		SoundSetting.gameBgm.setVolume(0.4f);
	}
	
	
	public void act(float delta){
		super.act(delta);
		
		if(!SoundSetting.gameBgm.isPlaying() && !crash && !menu && !out){
			SoundSetting.gameBgm.play();
		}
		
		if(!pause){
			bgRiver1.updateSpeed(speed);
			bgRiver2.updateSpeed(speed);
			bgRiver3.updateSpeed(speed);
			bgRiver4.updateSpeed(speed);
			bgRiver5.updateSpeed(speed);
		}
		
		if(!pause && !crash){
			timeStart+=delta;
			distance += delta;
		}
		
		if(timeStart > 3) // game start after 3 second
			gameStart();
		
		if(distance > 5 && !pause){
			if(speed < 800)
				speed = speed + 5;
			
			distance = 0;
		}
		
		if(crash){
			afterCrash+=delta;
			
			if(afterCrash > 4){
				
				result = true;
			}
		}
		
		
		
	}
	
	public void pause(){
		
		menuButton.show = true;
		resumeButton.show = true;
		
		
		
		
		Iterator<EnemyCar> iterCars = enemyCars.iterator();
		Iterator<Trash> iterTrashs = trashs.iterator();
		
		bgRiver1.clearActions();
		bgRiver2.clearActions();
		bgRiver3.clearActions();
		bgRiver4.clearActions();
		bgRiver5.clearActions();

		
		
		playerActor.clearActions();
		playerActor.show= false;
		
		while (iterTrashs.hasNext()) {
			Trash trash =  iterTrashs.next();
			trash.show = false;
			trash.clearActions();
		}
		
		while (iterCars.hasNext()) {
			
			EnemyCar enemyCar =  iterCars.next();
			enemyCar.show = false;
			enemyCar.clearActions();
		}
		
		pause = true;
	}
	
	public void resume(){
		
		
		menuButton.show = false;
		resumeButton.show = false;

		
		playerActor.show = true;
		
		Iterator<EnemyCar> iterCars = enemyCars.iterator();
		Iterator<Trash> iterTrashs = trashs.iterator();
		
		while (iterTrashs.hasNext()) {
			Trash trash =  iterTrashs.next();
			trash.show = true;
			trash.addAction(moveTo(trash.getX(), 0-(50+(GoBicycle.HEIGHT-trash.getY())), (GoBicycle.HEIGHT+50)/speed ));	
		}
		
		while (iterCars.hasNext()) {
			EnemyCar enemyCar =  iterCars.next();
			enemyCar.show = true;
			enemyCar.addAction(moveTo(enemyCar.getX(), 0-(enemyCar.getHeight()+(GoBicycle.HEIGHT-enemyCar.getY())), (GoBicycle.HEIGHT+50)/speed ));	
			
		}
		
		pause = false;
		
	}
	
//	private void bgScrool(){
//		
//		if(bgRiver1.getActions().size==0){
//			System.out.println(timeStart);
//			bgRiver1 = new CityScroll(getWidth(), getHeight(), 0, 800, speed, 1, false);
//			addActor(bgRiver1);
//		}
//		
//		if(bgRiver2.getActions().size == 0){
//			System.out.println(timeStart);
//			bgRiver2 = new CityScroll(getWidth(), getHeight(), 0, 800, speed, 2, false);
//			addActor(bgRiver2);
//		}
//	}
	
	private void gameStart(){
		
		
		
		
//		Setting.prefs.putInteger("Score", counter); // save state jangan dilakukan disini (lambat)
		
		
//		if(timeStart<200){
//			if (!pause && TimeUtils.nanoTime() - lastCarTime > MathUtils.random(3000000000f-timeStart*10000000,5000000000f-timeStart*10000000) && !crash) 
//				spawnCar();
//		}else{
//			if (!pause && (TimeUtils.nanoTime() - lastCarTime > MathUtils.random(1000000000f,3000000000f))  && !crash) 
//				spawnCar();
//		}
		
		
		
		
//		if(!pause && TimeUtils.nanoTime()- lastTrashTime > 1000000000f   && !crash) 
//			spawnTrash();
		
		if(!pause && timeStart - lastTrashTime > 1f   && !crash) 
			spawnTrash();
		
		if(timeStart<200){
			if (!pause && timeStart - lastCarTime > MathUtils.random(3f-timeStart*0.01f,5f-timeStart*0.01f) && !crash) 
				spawnCar();
			
		}else{
			if (!pause && (timeStart - lastCarTime > MathUtils.random(1f,3f))  && !crash) 
				spawnCar();
			
		}
		
		Iterator<EnemyCar> iterCars = enemyCars.iterator();
		Iterator<Trash> iterTrashs = trashs.iterator();
		
		
		while (iterCars.hasNext()) {
			EnemyCar enemyCar = iterCars.next();
			
			
			if (enemyCar.getBounds().y  <= -enemyCar.getHeight()) { // Jika object keluar dari area game
//				System.out.println("keluar");
				iterCars.remove();
				removeActor(enemyCar);
			}
			
			if(enemyCar.getBounds().overlaps(playerActor.getBounds()) && !crash){// player crash
				playerActor.crash(speed);			
				SoundSetting.gameBgm.stop();
				SoundSetting.crashSound.play();
				
				crash = true;
			}
			
			while (iterTrashs.hasNext()) {

				
				Trash trash =  iterTrashs.next();
				
				if(trash.getBounds().y <= -trash.getHeight()){
					iterTrashs.remove();
					removeActor(trash);
				}
				if(trash.getBounds().overlaps(playerActor.getBounds()) && !crash){ 
					counter++;
					score.setText(Integer.toString(counter));
					iterTrashs.remove();
					removeActor(trash);
					SoundSetting.trashSound.play();
				}
				
				if(enemyCar.getBounds().overlaps(trash.getBounds()) && iterTrashs.hasNext()){
					
					iterTrashs.remove();
					removeActor(trash);
					System.out.println("batu");
				}

				
			}
			
			
		}
	
		
		while (iterTrashs.hasNext()) {
			Trash trash =  iterTrashs.next();
			
			if(trash.getBounds().y <= -trash.getHeight()){
				iterTrashs.remove();
				removeActor(trash);
			}
			if(trash.getBounds().overlaps(playerActor.getBounds()) && !crash){ 
				counter++;
				score.setText(Integer.toString(counter));
				iterTrashs.remove();
				removeActor(trash);
				SoundSetting.trashSound.play();
			}
			
		

			
		}
//		Setting.prefs.flush();
	}
	
	private void spawnCar(){
		
		int lane = MathUtils.random(0,2); // random spawn line 0 - 2
		
		float xPos = 0;
		if (lane == 0) xPos = lane0;
		if (lane == 1) xPos = lane1;
		if (lane == 2) xPos = lane2;
		EnemyCar enemyCar = new EnemyCar(xPos, getHeight(),speed);
		enemyCar.show = true;
		enemyCars.add(enemyCar);
		addActor(enemyCar);
//		lastCarTime = TimeUtils.nanoTime();
		lastCarTime = timeStart;
	}
	
	private void spawnTrash(){
		int lane = MathUtils.random(0,2);
		float xPos = 0;
		if (lane == 0) xPos = lane0;
		if (lane == 1) xPos = lane1;
		if (lane == 2) xPos = lane2;
		Trash trash = new Trash(xPos, getHeight(),speed);
		trash.addAction(moveTo(xPos-50/2, 0-50, (GoBicycle.HEIGHT+50)/speed ));
		trash.show = true;
		trashs.add(trash);
		addActor(trash);
//		lastTrashTime = TimeUtils.nanoTime();
		lastTrashTime = timeStart;
	}
	
	public void draw(SpriteBatch batch,float parentAlpha){
		batch.setColor(Color.WHITE);
		super.draw(batch, parentAlpha);
		batch.draw(Asset.resultAtlas.findRegion("sampah1"), 20f,getHeight() - 50f, 30, 30f);
	}
}
