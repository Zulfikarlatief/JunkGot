package Arkode.zword.GoBicycle.Actor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;

import Arkode.zword.GoBicycle.GoBicycle;
import Arkode.zword.GoBicycle.Control.Asset;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class EnemyCar extends Actor{
	private Rectangle bounds = new Rectangle();
	private float speed;
	
	public boolean show = false;
	
	public EnemyCar(float x,float y,float speed) {
		// TODO Auto-generated constructor stub
//		setWidth(160);
//		setHeight(85);
		setWidth(80);
		setHeight(80);
		
		this.speed = speed;

		setPosition(x-getWidth()/2, y);
//		addAction(moveTo(GoBicycle.WIDTH +getWidth(), getY(), MathUtils.random(1.0f, 6.0f)));
		
		addAction(moveTo(getX(), 0-getHeight(), (GoBicycle.HEIGHT+getHeight())/speed));

	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		updateBounds();
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(show)
			batch.draw(Asset.stone, getX(), getY(), getWidth()/2, getHeight()/2, getWidth(), getHeight(), 1, 1, getRotation());//dibalik
		super.draw(batch, parentAlpha);
		

	}
	
	public Rectangle getBounds() {
		return bounds;
	}


	private void updateBounds(){
		bounds.set(getX(), getY(), getWidth(), getHeight());

	}
}
