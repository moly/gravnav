package org.flixelgdx.gravnav;

import org.flixel.*;

public class RepeatingBackground extends FlxObject
{
	private FlxSprite _panel;
	private int _numRepeats;
	
	public RepeatingBackground(String graphic, int numRepeats)
	{
		_panel = new FlxSprite(0, 0, graphic);
		_numRepeats = numRepeats;
	}
	
	@Override
	public void draw()
	{
		int x = (int) ((int)((FlxG.camera.scroll.x * scrollFactor.x) / _panel.width) * _panel.width);
		for(int i = 0; i < _numRepeats; i++)
		{
			_panel.x = x + (i * _panel.width);
			_panel.scrollFactor.x = scrollFactor.x;
			_panel.draw();
		}
	}
}
