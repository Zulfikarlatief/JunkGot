package Arkode.zword.GoBicycle.Actor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import Arkode.zword.GoBicycle.Control.Asset;
import Arkode.zword.GoBicycle.Control.Setting;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.TimeUtils;

public class BikeActor extends Actor{
	private City city;
	private Rectangle bounds = new Rectangle();
	public boolean countCrash = false;
	
	public boolean show = false;

	private int lane;
	private int rotation= 0;
	
	private float move;
	
	public BikeActor(City city){
//		this.city = city;
//		setWidth(85);
//		setHeight(160);
//		lane = 1;
//		setPosition(city.getWidth() - 200 , city.lane1-getHeight()/2);
//		setColor(Color.RED);
		
		this.city = city;
		setWidth(85);
		setHeight(160);
		lane = 1;
//		setPosition(city.lane1 - getWidth()/2 , 50);
		
		setPosition(city.lane1 - getWidth()/2, -getHeight());

	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		if(show)
		batch.draw(Asset.player, getX(), getY(), getWidth()/2, getHeight()/2, getWidth(), getHeight(), 1, 1, getRotation()+rotation);
	}
	
	public void act(float delta){
		super.act(delta);
		staticPos();
		drawMove(delta);
		
		updateBonds();
	}
	
	private void drawMove(float delta){
		move +=delta;
		if(!countCrash){
			if(move%0.6<0.2){
				if(Setting.prefs.getInteger("hero")==0)
					Asset.player = Asset.charAtlas.findRegion("h1a");
				else
					Asset.player = Asset.charAtlas.findRegion("h2a");
			}
			else if (move % 0.6<0.4) {
				if(Setting.prefs.getInteger("hero")==0)
					Asset.player = Asset.charAtlas.findRegion("h1b");
				else
					Asset.player = Asset.charAtlas.findRegion("h2b");
			}else {
				if(Setting.prefs.getInteger("hero")==0)
					Asset.player = Asset.charAtlas.findRegion("h1c");
				else
					Asset.player = Asset.charAtlas.findRegion("h2c");
			}
		}
	}
	
	private void staticPos(){
		if(getActions().size==0){
			rotation = 0;
		}
	}
	
	private void updateBonds(){
		if(getActions().size!=0)
			bounds.set(getX(),getY()+50,getWidth(),getHeight()-100);
		else {
			bounds.set(getX(),getY()+50,getWidth(),getHeight()-50);
		}
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void moveLeft(){
		if((getActions().size == 0)&& (lane != 2)){
			moveToLane(lane+1);
			rotation = 335;
		}
	}
	
	public void moveRight(){
		if((getActions().size == 0) && (lane != 0 )){
			moveToLane(lane-1);
			rotation = 25;
		}
	}
	
	public void crash(float speed){
		
		countCrash = true;

		moveOutArea(speed);
		
		
	}
	
	public void moveOutArea(float speed){
			addAction(moveTo(getX() , -getHeight() , (getY()+getHeight())/speed  ));
			if(Setting.prefs.getInteger("hero")==0)
				Asset.player = Asset.charAtlas.findRegion("h1a");
			else
				Asset.player = Asset.charAtlas.findRegion("h2a");
		
	}
	
	public void moveToPosPlay(){
		addAction(moveTo(city.lane1 - getWidth()/2 , 50 , 1f));
	}
	
	private void moveToLane(int lane){
		this.lane = lane;
//		switch(lane){
//			case 0:
//				addAction(moveTo(getX(),city.lane0 - getHeight()/2,0.25f));
//				break;
//			case 1:
//				addAction(moveTo(getX(), city.lane1 - getHeight()/2,0.25f));
//				break;
//			case 2:
//				addAction(moveTo(getX(),city.lane2 - getHeight()/2,0.25f));
//		}
		switch(lane){
		case 0:
			addAction(moveTo(city.lane0 - getWidth()/2 ,getY() , 0.25f) );
			break;
		case 1:
			addAction(moveTo(city.lane1 - getWidth()/2 ,getY() , 0.25f) );
			break;
		case 2:
			addAction(moveTo(city.lane2 - getWidth()/2 ,getY() , 0.25f) );
	}

		
	}

}
