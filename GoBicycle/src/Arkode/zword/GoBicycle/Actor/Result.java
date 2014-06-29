package Arkode.zword.GoBicycle.Actor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;

import java.util.Iterator;

import sun.awt.image.PixelConverter.Bgrx;
import Arkode.zword.GoBicycle.GoBicycle;
import Arkode.zword.GoBicycle.Control.Asset;
import Arkode.zword.GoBicycle.Control.SoundSetting;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Result extends Table{
	
	private float timeStart =0;
	
	private Text tScore;
	private Text tDistance;
	
	public ButtonImage image;
	
	private Array<Trash> trashs;
	
	private long lastTrashTime = 0;
	
	public Result(float distance , int score) {
		// TODO Auto-generated constructor stub
		
		setClip(true);
		
		setBounds(0, 0, 480, 800); // set lebar dan panjang tempat
		
		image = new ButtonImage(240, 0, 480, 800, Asset.resultAtlas.findRegion("overScreen"), true);
		addActor(image);
		image.show = true;
		
		image.addAction(Actions.fadeOut(0));
		image.addAction(Actions.fadeIn(3));
		
		LabelStyle ls = new LabelStyle(Asset.scoreFont, Color.WHITE); // new style text 
		LabelStyle ls2 = new LabelStyle(Asset.scoreFont, Color.YELLOW); // new style text 
		
		tScore = new Text(Integer.toString(score), ls2, 280f,getHeight() - 245f, getWidth(), 30f); // new score
		tDistance = new Text(Integer.toString((int)distance), ls, 280f,getHeight() - 145f, getWidth(), 30f); // new score
		addActor(tScore);
		addActor(tDistance);
		
		trashs = new Array<Trash>();
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		
		Trash trash;
		
		if (TimeUtils.nanoTime() - lastTrashTime > MathUtils.random(5000000000f, 10000000000f) && image.getActions().size==0) 
			spawnTrash();

		
		timeStart+= delta;
		
		if(timeStart > 4 && !tDistance.show){
			SoundSetting.scoreSound.play();
			tDistance.show = true;
		}
		
		if(timeStart > 5 && !tScore.show){
			tScore.show = true;
			SoundSetting.scoreSound.play();			
		}
		
		Iterator<Trash> iterTrashs = trashs.iterator();
		
		while (iterTrashs.hasNext()) {
			trash =  iterTrashs.next();
			
			if(trash.getBounds().x <= -trash.getWidth()){
				iterTrashs.remove();
				removeActor(trash);
			}			
			
		}

		
	}
	
	private void spawnTrash(){
		Trash trash = new Trash(GoBicycle.WIDTH, MathUtils.random(30, 70) ,100);
		trash.setWidth(80);trash.setHeight(80);
		if(MathUtils.random(1, 2)==1)
			trash.updateTexture(Asset.resultAtlas.findRegion("sampah1"));
		else {
			trash.updateTexture(Asset.resultAtlas.findRegion("sampah2"));
		}
		
		trash.show = true;
		trash.addAction(moveTo(0-trash.getWidth(), trash.getY(), (GoBicycle.WIDTH+50)/100 ));
		trashs.add(trash);
		addActor(trash);
		lastTrashTime = TimeUtils.nanoTime();

	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
//		batch.draw(Asset.bgAtlas.findRegion("MenuBg"), 0, 0, 480, 800);
		super.draw(batch, parentAlpha);
		batch.draw(Asset.resultAtlas.findRegion("batu"), GoBicycle.WIDTH-100, 0, 100, 200);		
		
		
		
	}
}
