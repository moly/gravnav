package org.flixelgdx.gravnav;

import org.flixel.*;

public class TitleScreen extends FlxState
{
	@Override
	public void create()
	{
		FlxObject menu = new FlxSprite(0, 0, "MenuFinal.png");
		menu.x = (FlxG.width - menu.width) / 2f;
		menu.scrollFactor.x = 0;
		add(menu);
		
		FlxSprite startText = new FlxSprite(0, 180);
		startText.loadGraphic("zxMenu.png", true, false, 39, 13);
		startText.x = (FlxG.width - startText.width) / 2f;
		startText.scrollFactor.x = 0;
		startText.addAnimation("flash", new int[]{0, 1}, 4, true);
		startText.play("flash");
		add(startText);
	}
}
