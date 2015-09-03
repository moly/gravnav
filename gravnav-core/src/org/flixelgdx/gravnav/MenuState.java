package org.flixelgdx.gravnav;

import org.flixel.*;

public class MenuState extends FlxState
{
	@Override
	public void create()
	{
		FlxG.setBgColor(0xFF2F567C);
		
		int repeatsNeeded = FlxU.ceil(FlxG.width / 240f) + 1;
		
		FlxObject stars = new RepeatingBackground("Stars1.png", repeatsNeeded);
		add(stars);
		
		stars = new RepeatingBackground("Stars2.png", repeatsNeeded);
		stars.scrollFactor.x = 0.5f;
		add(stars);
		
		FlxObject menu = new FlxSprite(0, 0, "MenuFinal.png");
		menu.x = (FlxG.width - menu.width) / 2f;
		menu.scrollFactor.x = 0;
		add(menu);
		
		FlxSprite startText = new FlxSprite(0, 180);
		startText.loadGraphic("zxMenu.png", true, false, 39, 13);
		startText.addAnimation("flash", new int[]{0, 1}, 4, true);
		startText.play("flash");
		startText.x = (FlxG.width - startText.width) / 2f;
		startText.scrollFactor.x = 0;
		add(startText);
	}
	
	@Override
	public void update()
	{
		super.update();
		FlxG.camera.scroll.x += FlxG.elapsed * 30;
	}
}
