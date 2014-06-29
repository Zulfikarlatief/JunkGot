package Arkode.zword.GoBicycle.Actor;

import Arkode.zword.GoBicycle.Control.Asset;
import Arkode.zword.GoBicycle.Control.SoundSetting;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Info extends Table{
	
	public ButtonImage next;
	public ButtonImage back;
	public ButtonImage home;
	
	private int currentPos = 1;
	
	public boolean pause = false;

	public boolean menu = false;
	
	public Info() {
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

		next = new ButtonImage(380, 45, 140, 70 , Asset.infoAtlas.findRegion("next") , true){
			@Override
			public void afterTouch() {
				// TODO Auto-generated method stub
				super.afterTouch();
				SoundSetting.buttonSound.play();
				currentPos++;
				next.show = true;
				back.show = true;
			}
		};
		
		back = new ButtonImage(100, 45, 140, 70 , Asset.infoAtlas.findRegion("back") , true){
			@Override
			public void afterTouch() {
				// TODO Auto-generated method stub
				super.afterTouch();
				SoundSetting.buttonSound.play();
				currentPos--;
				next.show = true;
				back.show = true;
			}
		};

		
		addActor(home);
		addActor(next);
		addActor(back);
		
		home.show = true;
		next.show = true;
		back.show = true;
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		
		if(!SoundSetting.menuBgm.isPlaying() && !pause)
			SoundSetting.menuBgm.play();

		
		if(currentPos == 1){
			back.show = false;
		}
		else if (currentPos == 2) {
			next.show = false;
		}
		
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(currentPos == 1){
			batch.draw(Asset.infoAtlas.findRegion("infoA"), 0, 0, 480, 800);
		}else if (currentPos == 2) {
			batch.draw(Asset.infoAtlas.findRegion("infoB"), 0, 0, 480, 800);
		}	
		super.draw(batch, parentAlpha);
	}
}
