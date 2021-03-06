package org.flixelgdx.gravnav;

import org.flixel.*;

public class Player extends FlxSprite
{
	private final GhostTrail _trail;
	
	public Player(int x, int y)
	{
		super(x, y);		
		
		loadGraphic("Player.png", true, true, 12, 15);

		addAnimation("up", new int[]{0, 1}, 4);
		addAnimation("down", new int[]{2, 3}, 4);
		
		height = 9;
		offset.y = 3;
		maxVelocity.y = 350;
		
		_trail = new GhostTrail(this, 133, 10);
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
			
			_trail.update();
		}
	}
	
	@Override
	public void draw()
	{
		_trail.draw();
		
		super.draw();
	}
}
