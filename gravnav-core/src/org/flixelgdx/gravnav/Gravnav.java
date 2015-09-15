package org.flixelgdx.gravnav;

import org.flixel.FlxCamera;
import org.flixel.FlxGame;
import org.flixelgdx.gravnav.menu.MenuState;

public class Gravnav extends FlxGame
{
	public Gravnav()
	{
		super(240, 240, MenuState.class, 2, 60, 60, true, FlxCamera.RESIZE_WIDTH);
	}
}
