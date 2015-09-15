package org.flixelgdx.gravnav;

import org.flixel.*;

public class Player extends FlxSprite
{	
	public Player(int x, int y)
	{
		super(x, y);		
		
		loadGraphic("Player.png", true, true, 12, 15);

		addAnimation("up", new int[]{0, 1}, 4);
		addAnimation("down", new int[]{2, 3}, 4);
		
		maxVelocity.y = 350;
	}
	
	@Override
	public void update()
	{
		super.update();
		
		if(FlxG.keys.justPressed("Z"))
			velocity.x = 50;
		
		if(velocity.x > 0)
		{
			if(y > 0 && FlxG.keys.Z || y > 240 - height)
			{
				acceleration.y = -300;
				play("up");
			}
			else
			{
				acceleration.y = 300;
				play("down");
			}
		}
	}
}
