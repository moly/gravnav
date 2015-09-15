package org.flixelgdx.gravnav.menu;

import org.flixel.*;

public class CreditScreen extends FlxState
{
	@Override
	public void create()
	{
		FlxSprite instructions = new FlxSprite(0, 0, "CreditScreen.png");
		instructions.x = (FlxG.width - instructions.width) / 2f;
		instructions.scrollFactor.x = 0;
		add(instructions);
	}
}
