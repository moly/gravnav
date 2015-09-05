package org.flixelgdx.gravnav;

import org.flixel.*;

public class MenuState extends FlxState
{
	private FlxState _currentScreen;
	
	private FlxState _titleScreen;
	private FlxState _instructionsScreen;
	private FlxState _creditScreen;
	
	@Override
	public void create()
	{
		FlxG.setBgColor(0xFF2F567C);
		
		FlxG.playMusic("WhenMyStomachTurns.mp3");
		
		int repeatsNeeded = FlxU.ceil(FlxG.width / 240f) + 1;
		
		FlxObject stars = new RepeatingBackground("Stars1.png", repeatsNeeded);
		add(stars);
		
		stars = new RepeatingBackground("Stars2.png", repeatsNeeded);
		stars.scrollFactor.x = 0.5f;
		add(stars);
		
		_titleScreen = new TitleScreen();
		_titleScreen.create();
		
		_instructionsScreen = new InstructionsScreen();
		_instructionsScreen.create();
		
		_creditScreen = new CreditScreen();
		_creditScreen.create();
		
		_currentScreen = _titleScreen;
		add(_currentScreen);
	}
	
	@Override
	public void update()
	{
		super.update();
		
		FlxG.camera.scroll.x += FlxG.elapsed * 30;
		
		if(_currentScreen == _titleScreen)
		{
			if(FlxG.keys.justPressed("I"))
			{
				replace(_currentScreen, _instructionsScreen);
				_currentScreen = _instructionsScreen;
			}
			else if(FlxG.keys.justPressed("C"))
			{
				replace(_currentScreen, _creditScreen);
				_currentScreen = _creditScreen;
			}
			else if(FlxG.keys.justPressed("M"))
				 FlxU.openURL("http://adnissen.com/");
		}
		else if(FlxG.keys.justPressed("ESCAPE"))
		{
			replace(_currentScreen, _titleScreen);
			_currentScreen = _titleScreen;
		}
	}
}
