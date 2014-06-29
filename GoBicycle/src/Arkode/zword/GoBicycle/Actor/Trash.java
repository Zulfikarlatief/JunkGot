package Arkode.zword.GoBicycle.Actor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;

import Arkode.zword.GoBicycle.GoBicycle;
import Arkode.zword.GoBicycle.Control.Asset;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

public class Trash extends Actor{
	
	private Rectangle bounds = new Rectangle();
	
	public TextureRegion trash;
	
	public boolean show = false;
	
	public Trash(float x, float y,float speed) {
	// TODO Auto-generated constructor stub
		setWidth(50);
		setHeight(50);
//		setPosition(x-getWidth(), y-getHeight()/2);
//		addAction(moveTo(GoBicycle.WIDTH +getWidth(), getY(), 2f));
		
		setPosition(x-getWidth()/2, y);
		
//		addAction(moveTo(getX(), 0-getHeight(), (GoBicycle.HEIGHT+getHeight())/speed ));
		
		
		
		
		
		int style = MathUtils.random(1, 3);
		if(style==1)
			trash = Asset.dOther.findRegion("trash1");
		else if (style == 2) {
			trash = Asset.dOther.findRegion("trash2");
		}else {
			trash = Asset.dOther.findRegion("trash3");
		}
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		updateBounds();
	}
	
	public void updateTexture(TextureRegion textureRegion){
		trash = textureRegion;
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
		if(show)
		batch.draw(trash, getX(), getY(), getWidth()/2, getHeight()/2, getWidth(), getHeight(), 1, 1, getRotation());//dibalik

		super.draw(batch, parentAlpha);
//		batch.draw(Asset.car, getX(), getY(), getWidth()/2, getHeight()/2, getWidth(), getHeight(), 1, 1, getRotation());//dibalik


	}
	
	public Rectangle getBounds() {
		return bounds;
	}


	private void updateBounds(){
		bounds.set(getX(), getY(), getWidth(), getHeight());

	}
}
