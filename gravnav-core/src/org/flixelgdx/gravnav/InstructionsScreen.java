package org.flixelgdx.gravnav;

import org.flixel.*;

public class InstructionsScreen extends FlxState
{
	@Override
	public void create()
	{
		FlxSprite instructions = new FlxSprite(0, 0, "Instructions.png");
		instructions.x = (FlxG.width - instructions.width) / 2f;
		instructions.scrollFactor.x = 0;
		add(instructions);
		
		FlxSprite arrow = new FlxSprite(instructions.x + 82, 149);
		arrow.loadGraphic("InstructionArrow.png", true, false, 77, 66);
		arrow.scrollFactor.x = 0;
		arrow.addAnimation("flash", new int[]{0, 1, 2}, 6, true);
		arrow.play("flash");
		add(arrow);
	}
}
