package org.flixelgdx.gravnav;

import org.flixel.FlxCamera;
import org.flixel.FlxGame;

public class Gravnav extends FlxGame
{
	public Gravnav()
	{
		super(240, 240, MenuState.class, 2, 60, 60, true, FlxCamera.RESIZE_WIDTH);
	}
}
