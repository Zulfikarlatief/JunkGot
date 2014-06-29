package Arkode.zword.GoBicycle.Actor;

import sun.awt.image.PixelConverter.Bgrx;
import Arkode.zword.GoBicycle.Control.Asset;
import Arkode.zword.GoBicycle.Control.SoundSetting;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Menu extends Table{
		
		public ButtonImage buttonStart;
		public ButtonImage buttonAchievement;
		public ButtonImage buttonHScore;
		public ButtonImage buttonSetting;
		
		public ButtonImage buttonNo;
		public ButtonImage buttonYes;
		
		public boolean pause = false;
		public boolean quit = false;

		
		public boolean isStart = false;
		public boolean isAchieve = false;
		public boolean isSetting = false;
		public boolean isScore = false;
		
		public Menu() {
			// TODO Auto-generated constructor stub
			setClip(true);
			
			setBounds(0, 0, 480, 800); // set lebar dan panjang tempat
			
			buttonNo = new ButtonImage(340, 340, 120, 60 , Asset.menuAtlas.findRegion("no") , true){
				@Override
				public void afterTouch() {
					// TODO Auto-generated method stub
					super.afterTouch();
					SoundSetting.buttonSound.play();
					quit = false;
				}
			};
			
			buttonYes = new ButtonImage(140, 340, 120, 60 , Asset.menuAtlas.findRegion("yes") , true){
				@Override
				public void afterTouch() {
					// TODO Auto-generated method stub
					super.afterTouch();
					SoundSetting.buttonSound.play();
					Gdx.app.exit();
				}
			};
			
			buttonStart = new ButtonImage(240, 50, 380, 150 , Asset.menuAtlas.findRegion("btnPlay") , true){
				@Override
				public void afterTouch() {
					// TODO Auto-generated method stub
					super.afterTouch();
					if(!quit){
						SoundSetting.buttonSound.play();
						isStart = true;
						SoundSetting.menuBgm.stop();
					}

				}
			};
			
			buttonAchievement = new ButtonImage(240, 200, 80, 80, Asset.menuAtlas.findRegion("btnAchievement"), false){
				@Override
				public void afterTouch() {
					// TODO Auto-generated method stub
					super.afterTouch();
					if(!quit){
						SoundSetting.buttonSound.play();
						isAchieve = true;
					}
				}
			};
			
			buttonHScore = new ButtonImage(120, 200, 80, 80, Asset.menuAtlas.findRegion("btnHighScore"), false){
				
				@Override
				public void afterTouch() {
					// TODO Auto-generated method stub
					super.afterTouch();
					if(!quit){
						SoundSetting.buttonSound.play();
						isScore = true;
					}
				}
			};
			
			buttonSetting = new ButtonImage(360, 200, 80, 80, Asset.menuAtlas.findRegion("btnOption"), false){
				
				@Override
				public void afterTouch() {
					// TODO Auto-generated method stub
					super.afterTouch();
					
					if(!quit){
						SoundSetting.buttonSound.play();
						isSetting = true;
					}
				}
			};
			
			buttonAchievement.show = true;
			buttonStart.show = true;
			buttonHScore.show = true;
			buttonSetting.show = true;
			
			addActor(buttonAchievement);
			addActor(buttonStart);
			addActor(buttonHScore);
			addActor(buttonSetting);
			
			addActor(buttonNo);
			addActor(buttonYes);
		}
		
		@Override
		public void act(float delta) {
		// TODO Auto-generated method stub
			if(!SoundSetting.menuBgm.isPlaying() && !pause){
				SoundSetting.menuBgm.play();
				SoundSetting.menuBgm.setVolume(0.3f);
			}
			
			if(quit){
				buttonNo.show = true;
				buttonYes.show = true;
			}else {
				buttonNo.show = false;
				buttonYes.show = false;
			}
			

			
			super.act(delta);
		}
		
		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
			batch.draw(Asset.menuAtlas.findRegion("bgMenu"), 0, 0, 480, 800);
			
			if(quit)
				batch.draw(Asset.menuAtlas.findRegion("board"), 240 - 200, 300, 400, 200);
			
			super.draw(batch, parentAlpha);
		}
}
