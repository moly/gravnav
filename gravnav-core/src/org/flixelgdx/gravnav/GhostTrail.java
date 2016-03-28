package org.flixelgdx.gravnav;

import org.flixel.*;

public class GhostTrail extends FlxBasic
{
	private final FlxSprite _spriteToTrail;
	private final int _interval;
	
	private FlxGroup _ghosts;
	private int _counter;
	
	public GhostTrail(FlxSprite spriteToTrail, int interval, int maxGhosts)
	{
		_spriteToTrail = spriteToTrail;
		_interval = interval;
		
		_ghosts = new FlxGroup(maxGhosts);
	}
	
	@Override
	public void update()
	{
		_counter += (FlxG.elapsed * 1000);
		
		if(_counter >= _interval)
		{
			FlxSprite ghost = (FlxSprite) _ghosts.recycle(FlxSprite.class);
			ghost.framePixels.set(_spriteToTrail.framePixels);
			ghost.x = _spriteToTrail.x;
			ghost.y = _spriteToTrail.y;
			ghost.setAlpha(0.3f);
			ghost.dirty = false;
			
			_counter = 0;
		}
	}
	
	@Override
	public void draw()
	{
		_ghosts.draw();
	}
}
