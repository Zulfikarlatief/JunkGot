package Arkode.zword.GoBicycle.Actor;

import Arkode.zword.GoBicycle.GoBicycle;
import Arkode.zword.GoBicycle.Control.Asset;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class ButtonImage extends Actor{
//		private OrthographicCamera cam = new OrthographicCamera();
	
		private Rectangle boundsRec ;
		private Circle boundsCir ;
		
		public boolean rect = false;
		
		public boolean show = false;
		
		public TextureRegion image;
		
		public ButtonImage(float x , float y , float width , float height ,TextureRegion image,boolean rect) {
			// TODO Auto-generated constructor stub
//			cam.setToOrtho(true, GoBicycle.WIDTH, GoBicycle.HEIGHT);
			
			setWidth(width);
			setHeight(height);
			if(rect){
				setPosition(x-getWidth()/2, y);
				boundsRec = new Rectangle();
			}
			else {
				setPosition(x-getWidth()/2, y);
				boundsCir = new Circle();
			}
			
			
			this.rect = rect;
			this.image = image;
			
		}
		
		@Override
		public void act(float delta) {
		// TODO Auto-generated method stub
			super.act(delta);
			updateBounds();
			
			if(Gdx.input.justTouched() && show){
				Vector3 touchpos = new Vector3
						(Gdx.input.getX(),GoBicycle.HEIGHT - Gdx.input.getY(),0);
				
				if(rect){
					if(getRectangle().contains(touchpos.x, touchpos.y)){//buton press
						afterTouch();
					}
					
					
				}else {
					if(getCircle().contains(touchpos.x, touchpos.y)){//buton press
						afterTouch();
					}
				}
			}
			
		}
		
		public void afterTouch(){
			
		}
		
		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
			super.draw(batch, parentAlpha);
			
//			batch.setProjectionMatrix(cam.combined); //untuk balik layar
			if(show){
				batch.setColor(this.getColor());
				batch.draw(image,getX(),getY(),getWidth(),getHeight());
			}

		}
		
	
		
		public Rectangle getRectangle() {
				return boundsRec;
		}
		
		public Circle getCircle(){
			return boundsCir;
		}


		private void updateBounds(){
			if(rect)
				boundsRec.set(getX(), getY(), getWidth(), getHeight());
			else {
				boundsCir.set(getX()+getWidth()/2, getY()+getWidth()/2, getWidth()/2);
			}

		}
}
