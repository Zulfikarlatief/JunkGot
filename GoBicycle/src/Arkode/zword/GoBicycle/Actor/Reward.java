package Arkode.zword.GoBicycle.Actor;

import Arkode.zword.GoBicycle.Control.Asset;
import Arkode.zword.GoBicycle.Control.Setting;
import Arkode.zword.GoBicycle.Control.SoundSetting;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Reward extends Table{
	
	public ButtonImage reward1;
	public ButtonImage reward2;
	public ButtonImage reward3;
	public ButtonImage reward4;
	public ButtonImage reward5;
	public ButtonImage reward6;
	public ButtonImage reward7;
	public ButtonImage reward8;
	public ButtonImage reward9;
	public ButtonImage reward10;
	public ButtonImage reward11;
	public ButtonImage reward12;
	
	public ButtonImage hero1;
	public ButtonImage hero2;
	
	public int choose = Setting.prefs.getInteger("hero");
	
	public ButtonImage home;
	
	private TextureRegion textureShow;
	
	public boolean pause = false;
	public boolean menu = false;

	public boolean rewardShow=false;
	private int rewardkode = 0;
	
	public Reward() {
		// TODO Auto-generated constructor stub
		setClip(true);
		
		setBounds(0, 0, 480, 800); // set lebar dan panjang tempat
		
		hero1 = new ButtonImage(140, 180, 80, 80 , Asset.heroAtlas.findRegion("hero chose") , true){
			@Override
			public void afterTouch() {
				// TODO Auto-generated method stub
				super.afterTouch();
				SoundSetting.buttonSound.play();				
				choose = 0;
				Setting.prefs.putInteger("hero", choose); 
				Setting.prefs.flush();
			}
		};
		
		hero2 = new ButtonImage(340, 180, 80, 80 , Asset.heroAtlas.findRegion("hero chose2") , true){
			@Override
			public void afterTouch() {
				// TODO Auto-generated method stub
				super.afterTouch();
				SoundSetting.buttonSound.play();				
				choose = 1;
				Setting.prefs.putInteger("hero", choose); 
				Setting.prefs.flush();
			}
		};
		
		
		home = new ButtonImage(240, 30, 80, 60 , Asset.infoAtlas.findRegion("home") , true){
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

		addActor(hero1);
		hero1.show = true;
		
		addActor(hero2);
		
		if(Setting.prefs.getFloat("Distance") > 500){
			hero2.show = true;
		}
		
//		reward7 = new ButtonImage(120, 250, 80, 133 , Asset.bgAtlas.findRegion("MenuBg") , true){
//			@Override
//			public void afterTouch() {
//				// TODO Auto-generated method stub
//				super.afterTouch();
//				rewardkode = 7;
//				rewardShow = true;
//			}
//		};
//		
//		
//		reward8 = new ButtonImage(240, 250, 80, 133 , Asset.bgAtlas.findRegion("MenuBg") , true){
//			@Override
//			public void afterTouch() {
//				// TODO Auto-generated method stub
//				super.afterTouch();
//				rewardkode = 8;
//				rewardShow = true;
//			}
//		};
//		
//		reward9 = new ButtonImage(360, 250, 80, 133 , Asset.bgAtlas.findRegion("MenuBg") , true){
//			@Override
//			public void afterTouch() {
//				// TODO Auto-generated method stub
//				super.afterTouch();
//				rewardkode = 9;
//				rewardShow = true;
//			}
//		};
		
		reward4 = new ButtonImage(120, 393, 80, 133 , Asset.rewardAtlas.findRegion("rEmpat") , true){
			@Override
			public void afterTouch() {
				// TODO Auto-generated method stub
				super.afterTouch();
				rewardkode = 4;
				rewardShow = true;
			}
		};
		
		reward5 = new ButtonImage(240, 393, 80, 133 , Asset.rewardAtlas.findRegion("rLima") , true){
			@Override
			public void afterTouch() {
				// TODO Auto-generated method stub
				super.afterTouch();
				rewardkode = 5;
				rewardShow = true;
			}
		};
		
		reward6 = new ButtonImage(360, 393, 80, 133 , Asset.rewardAtlas.findRegion("rEnam") , true){
			@Override
			public void afterTouch() {
				// TODO Auto-generated method stub
				super.afterTouch();
				rewardkode = 6;
				rewardShow = true;
			}
		};
		
		reward1 = new ButtonImage(120, 536, 80, 133 , Asset.rewardAtlas.findRegion("rSatu") , true){
			@Override
			public void afterTouch() {
				// TODO Auto-generated method stub
				super.afterTouch();
				rewardkode = 1;
				rewardShow = true;
			}
		};
		
		reward2 = new ButtonImage(240, 536, 80, 133 , Asset.rewardAtlas.findRegion("rDua") , true){
			@Override
			public void afterTouch() {
				// TODO Auto-generated method stub
				super.afterTouch();
				rewardkode = 2;
				rewardShow = true;
			}
		};
		
		reward3 = new ButtonImage(360, 536, 80, 133 , Asset.rewardAtlas.findRegion("rTiga") , true){
			@Override
			public void afterTouch() {
				// TODO Auto-generated method stub
				super.afterTouch();
				rewardkode = 3;
				rewardShow = true;
			}
		};
		
		addActor(reward1);
		addActor(reward2);
		addActor(reward3);
		addActor(reward4);
		addActor(reward5);
		addActor(reward6);
//		addActor(reward7);
//		addActor(reward8);
//		addActor(reward9);
		

		if(Setting.prefs.getInteger("Score") > 50)
			reward1.show = true;
		
		if(Setting.prefs.getInteger("Score") > 100)
			reward2.show = true;
		
		if(Setting.prefs.getInteger("Score") > 150)
			reward3.show = true;
		
		if(Setting.prefs.getInteger("Score") > 200)
			reward4.show = true;
		
		if(Setting.prefs.getInteger("Score") > 300)
			reward5.show = true;
		
		if(Setting.prefs.getInteger("Score") > 500)
			reward6.show = true;
		

		

	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		
		if(!SoundSetting.menuBgm.isPlaying() && !pause)
			SoundSetting.menuBgm.play();

		
		if(rewardShow){
			selectAsset();
		}
	}
	
	private void selectAsset(){
		switch (rewardkode) {
		case 1:
			textureShow = Asset.rewardAtlas.findRegion("rSatu");
			break;
		case 2:
			textureShow = Asset.rewardAtlas.findRegion("rDua");
			break;
		case 3:
			textureShow = Asset.rewardAtlas.findRegion("rTiga");
			break;
		case 4:
			textureShow = Asset.rewardAtlas.findRegion("rEmpat");
			break;
		case 5:
			textureShow = Asset.rewardAtlas.findRegion("rLima");
			break;
		case 6:
			textureShow = Asset.rewardAtlas.findRegion("rEnam");
			break;
		default:
			break;
		}
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		batch.draw(Asset.bgAchieve.findRegion("achievementBg"), 0, 0, 480, 800);
		super.draw(batch, parentAlpha);
		
		if(choose == 0 &&!rewardShow)
			batch.draw(Asset.heroAtlas.findRegion("5.buton (selected hero)"), 140-80/2, 150, 80, 20);
		else if(choose == 1 && !rewardShow){
			batch.draw(Asset.heroAtlas.findRegion("5.buton (selected hero)"), 340-80/2, 150, 80, 20);
		}

		if(rewardShow){
			batch.draw(Asset.rewardAtlas.findRegion("frame"), 0, 0, 480, 800);
			batch.draw(textureShow, 240-(370/2), 150, 370, 520);
			reward1.show = false;
			reward2.show = false;
			reward3.show = false;
			reward4.show = false;
			reward5.show = false;
			reward6.show = false;
//			reward7.show = false;
//			reward8.show = false;
//			reward9.show = false;
			
			home.show = false;
			
			hero1.show = false;
			hero2.show = false;
		}
	}
	
}
