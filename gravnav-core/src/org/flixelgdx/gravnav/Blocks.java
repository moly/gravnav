package org.flixelgdx.gravnav;

import org.flixel.FlxBasic;
import org.flixel.FlxG;
import org.flixel.FlxGroup;
import org.flixel.FlxSprite;
import org.flixel.FlxU;

public class Blocks extends FlxBasic
{
	private final FlxGroup _blocks;
	private final int _blocksPerWave;
	private final int _interval;
	
	private int _waveCounter;
	
	public Blocks(String graphic, int blocksPerWave, int interval)
	{
		_blocksPerWave = blocksPerWave;
		_interval = interval;
		
		_waveCounter = 0;
		
		_blocks = new FlxGroup(blocksPerWave * ((FlxG.width / interval) + 1));
		for(int i = 0; i < _blocks.getMaxSize(); i++)
			_blocks.add(new FlxSprite(-999,-999,graphic));
	}
	
	@Override
	public void update()
	{		
		if(FlxG.camera.scroll.x > _interval * _waveCounter)
		{	
			boolean[] gaps = new boolean[_blocksPerWave];
			int numberOfGaps = (int) FlxU.max(3 - (_waveCounter / 5), 1);
			for(int i = 0; i < numberOfGaps; i++)
				gaps[(int) (FlxG.random() * gaps.length)] = true;
			
			for(int i = 0; i < _blocksPerWave; i++)
			{
				if(!gaps[i])
				{
					FlxSprite block = (FlxSprite) _blocks.recycle();
					block.x = FlxG.camera.scroll.x + FlxG.width + 50;
					block.y = i * block.height;
				}
			}
			
			_waveCounter++;
		}
		

		_blocks.update();
	}
	
	@Override
	public void draw()
	{
		_blocks.draw();
	}

	public FlxGroup getBlocks()
	{
		return _blocks;
	}
}
