package Arkode.zword.GoBicycle.Actor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

	

public class Text extends Label{

	public boolean show=false;
	
	public Text(CharSequence text, LabelStyle style,float x, float y,float width,float height) {
		super(text, style);
		// TODO Auto-generated constructor stub
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);

		
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(show){
			super.draw(batch, parentAlpha);
		}
	}
	
	
	

}
