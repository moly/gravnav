package org.flixelgdx.gravnav;

import org.flixel.*;

public class PlayState extends FlxState
{
	private FlxText _scoreText;
	private Blocks _blocks;
	private FlipArrow _flipArrow;
	
	private int _flipInterval = 450;
	private int _flipCounter;
	
	@Override
	public void create()
	{
		int repeatsNeeded = FlxU.ceil(FlxG.width / 240f) + 1;
		
		FlxObject stars = new RepeatingBackground("Stars1.png", repeatsNeeded);
		stars.scrollFactor.x = 0.66f;
		add(stars);
		
		stars = new RepeatingBackground("Stars2.png", repeatsNeeded);
		stars.scrollFactor.x = 0.33f;
		add(stars);
		
		FlxSprite player = new Player(50, 100);
		GhostTrail trail = new GhostTrail(player, 133, 10);
		
		add(trail);
		add(player);
		
		_blocks = new Blocks("Block.png", 6, 183);
		add(_blocks);
		
		_flipArrow = new FlipArrow((FlxG.width - 165) / 2, (FlxG.height - 193) / 2);
		_flipArrow.visible = false;
		add(_flipArrow);
		
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
		
		int nextFlipDistance = _flipInterval * (_flipCounter + 1);
		
		if(FlxG.camera.scroll.x > nextFlipDistance - 180)
			_flipArrow.visible = true;
		
		if(FlxG.camera.scroll.x > nextFlipDistance)
		{
			FlxG.camera.setAngle(FlxG.camera.getAngle() + 180);
			_flipArrow.visible = false;
			_flipCounter++;
		}
		
		_scoreText.setText(String.valueOf((int)FlxG.camera.scroll.x));
	}
}
