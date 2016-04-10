package org.flixelgdx.gravnav;

import org.flixel.*;

public class PlayState extends FlxState
{	
	private FlxText _scoreText;
	
	@Override
	public void create()
	{
		int repeatsNeeded = FlxU.ceil(FlxG.width / 240f) + 1;
		
		FlxObject stars = new RepeatingBackground("Stars1.png", repeatsNeeded);
		add(stars);
		
		stars = new RepeatingBackground("Stars2.png", repeatsNeeded);
		stars.scrollFactor.x = 0.5f;
		add(stars);
		
		FlxSprite player = new Player(50, 100);
		GhostTrail trail = new GhostTrail(player, 133, 10);
		
		add(trail);
		add(player);
		
		_scoreText = new FlxText(0, 30, FlxG.width);
		_scoreText.setFormat("", 24, 0xFFFFFF, "center");
		_scoreText.scrollFactor.x = 0;
		add(_scoreText);
		
		FlxG.camera.follow(player);
		FlxG.camera.setBounds(0, 0, Float.MAX_VALUE, FlxG.height);
		FlxG.camera.deadzone = new FlxRect(player.x, 0, player.width, FlxG.height);
	}
	
	@Override
	public void update()
	{
		super.update();
		
		_scoreText.setText(String.valueOf((int)FlxG.camera.scroll.x));
	}
}
