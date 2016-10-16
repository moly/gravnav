package org.flixelgdx.gravnav;

import org.flixel.FlxEmitter;
import org.flixel.FlxG;
import org.flixel.FlxParticle;

public class DeathParticles extends FlxEmitter
{
	public float minLaunchAngle;
	public float maxLaunchAngle;
	
	public float minParticleVelocity;
	public float maxParticleVelocity;
	
	public DeathParticles(float X, float Y, int Size)
	{
		super(X, Y, Size);
		
		gravity = 300;
		
		minLaunchAngle = 0;
		maxLaunchAngle = 360;
		
		maxParticleVelocity = 300;
		minParticleVelocity = -300;
		
		for(int i = 0; i < Size; i++)
		{
			// first half of the particles are size one, second half size two
			int particleSize = i / (Size / 2) + 1;
			FlxParticle particle = new FlxParticle();
			particle.makeGraphic(particleSize, particleSize, 0xFFFFFFFF);
			particle.exists = false;
			add(particle);
		}
	}

	/**
	 * The standard flixel FlxEmitter emits particles in a noticeably square pattern.
	 * This overrides the default behaviour to make it a bit more circular.
	 */
	@Override
	public void emitParticle()
	{
		FlxParticle particle = (FlxParticle) recycle(particleClass);
		particle.lifespan = lifespan;
		particle.elasticity = bounce;
		particle.reset(x - ((int)particle.width>>1) + FlxG.random()*width, y - ((int)particle.height>>1) + FlxG.random()*height);
		particle.visible = true;

		float launchAngle = (float) Math.toRadians(minLaunchAngle + FlxG.random()*(maxLaunchAngle-minLaunchAngle));
		float velocity = minParticleVelocity + FlxG.random()*(maxParticleVelocity-minParticleVelocity);
		
		particle.velocity.x = (float) (Math.cos(launchAngle)*velocity);
		particle.velocity.y = (float) (Math.sin(launchAngle)*velocity);
		
		particle.acceleration.y = gravity;

		particle.angularVelocity = minRotation + FlxG.random()*(maxRotation-minRotation);
		
		if(particle.angularVelocity != 0)
			particle.angle = FlxG.random()*360-180;

		particle.drag.x = particleDrag.x;
		particle.drag.y = particleDrag.y;
		particle.onEmit();
	}
}
