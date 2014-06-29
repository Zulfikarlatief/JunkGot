package Arkode.zword.GoBicycle.Actor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.forever;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import Arkode.zword.GoBicycle.GoBicycle;
import Arkode.zword.GoBicycle.Control.Asset;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class CityScroll extends Actor{
	
	private TextureRegion river;
	private int pos;
	
	private float speed;
	
	public CityScroll(float width,float height,float x ,float y,float speed , int style, int pos){
//		setWidth(width);
//		setHeight(height);
//		setPosition(width, 0);
//		addAction(forever(sequence(moveTo(2 * width, 0, 1f/*speed*/), moveTo(width, 0))));
		if(pos == 1)
			river = Asset.riverAtlas.findRegion("map1a");
		else if(pos == 2)
			river = Asset.riverAtlas.findRegion("map1b");
		else if (pos == 3){
			river = Asset.riverAtlas.findRegion("map1c");
		}
		else if (pos == 4){
			river = Asset.riverAtlas.findRegion("map1d");
		}else {
			river = Asset.riverAtlas.findRegion("map1a");
		}
		
		this.pos = pos;
		
		setWidth(width);
		setHeight(height);
		setPosition(x, y);
//		addAction(forever(sequence(moveTo(0, -height + y, GoBicycle.HEIGHT/speed /*speed*/), moveTo(x, y))));
		
//		if(initial){
//			addAction(forever(sequence(moveTo(0, -800, GoBicycle.HEIGHT/speed /*speed*/), moveTo(0, 0))));
//		}
//		else {
//			addAction(forever(sequence(moveTo(0, 0, GoBicycle.HEIGHT/speed /*speed*/), moveTo(0, 800))));
//		}
		
//		if(initial){
//			addAction(moveTo(0, -800, GoBicycle.HEIGHT/speed /*speed*/));
//		}
//		else {
//			addAction(moveTo(0, 0, GoBicycle.HEIGHT/speed /*speed*/));
//		}
		
		
	}
	
	
	
	public void updateSpeed(float speed){
		if(getActions().size==0){
			
			if(pos==1){
				setPosition(0, 0);
				addAction(moveTo(0, -3200, GoBicycle.HEIGHT*4/speed /*speed*/));
			}
			else if(pos==2){
				setPosition(0, 800);
				addAction(moveTo(0, -2400, GoBicycle.HEIGHT*4/speed /*speed*/));
			}
			else if(pos == 3){
				setPosition(0, 1600);
				addAction(moveTo(0, -1600, GoBicycle.HEIGHT*4/speed /*speed*/));
			}
			else if(pos == 4){
				setPosition(0, 2400);
				addAction(moveTo(0, -800, GoBicycle.HEIGHT*4/speed /*speed*/));
			}
			else if(pos == 5){
				setPosition(0, 3200);
				addAction(moveTo(0, 0, GoBicycle.HEIGHT*4/speed /*speed*/));
			}
		}
		
	}
	
//	public void onPause(){
//		if(pos==1){
//			removeAction(moveTo(0, -3200, GoBicycle.HEIGHT*4/speed /*speed*/));
//		}
//		else  if(pos == 2){
//			removeAction(moveTo(0, -2400, GoBicycle.HEIGHT*4/speed /*speed*/));
//		}
//		else  if(pos == 3){
//			removeAction(moveTo(0, -1600, GoBicycle.HEIGHT*4/speed /*speed*/));
//		}
//		else  if(pos == 4){
//			removeAction(moveTo(0, -800, GoBicycle.HEIGHT*4/speed /*speed*/));
//		}
//		else  if(pos == 5){
//			removeAction(moveTo(0, 0, GoBicycle.HEIGHT*4/speed /*speed*/));
//		}
//	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
//		batch.draw(Asset.road, getX()-(2* getWidth()), getY(), getWidth() * 2, getHeight());
		batch.setColor(this.getColor());
		batch.draw(river, getX(), getY() , getWidth() , getHeight() );
		

		
	}
	

}
