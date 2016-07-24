package org.flixelgdx.gravnav;

import org.flixel.FlxSprite;

public class FlipArrow extends FlxSprite
{
	public FlipArrow(int x, int y)
	{
		super(x, y);
		
		loadGraphic("Arrow.png", true, false, 165, 193);
		addAnimation("flash", new int[]{0, 1, 2}, 6, true);
		scrollFactor.x = 0;
		angle = 90;
		
		play("flash");
	}
}
