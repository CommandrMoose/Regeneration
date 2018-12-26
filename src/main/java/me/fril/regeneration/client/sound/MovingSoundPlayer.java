package me.fril.regeneration.client.sound;

import me.fril.regeneration.common.capability.CapabilityRegeneration;
import me.fril.regeneration.common.capability.IRegeneration;
import me.fril.regeneration.util.RegenObjects;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;

/**
 * Created by Sub
 * on 20/09/2018.
 */
public class MovingSoundPlayer extends MovingSound {
	
	private final EntityPlayer player;
	private float distance = 0.0F;
	private SoundEvent soundCheck;
	
	
	public MovingSoundPlayer(EntityPlayer player, SoundEvent soundIn, SoundCategory categoryIn, boolean repeat) {
		super(soundIn, categoryIn);
		this.player = player;
		this.repeat = repeat;
		repeatDelay = 0;
		soundCheck = soundIn;
	}
	
	@Override
	public void update() {
		IRegeneration cap = CapabilityRegeneration.getForPlayer(player);
		
		if (soundCheck.getSoundName().equals(RegenObjects.Sounds.HAND_GLOW.getSoundName())) {
			volume = 0.3F; //XXX is this needed?
			if (!cap.isGlowing())
				donePlaying = true;
		}
		
		if (soundCheck.getSoundName().equals(RegenObjects.Sounds.HEART_BEAT.getSoundName())) {
			if (!cap.isInGracePeriod())
				donePlaying = true;
		}
		
		if (soundCheck.getSoundName().equals(RegenObjects.Sounds.REGENERATION.getSoundName())) {
			if (cap.getTicksRegenerating() == 199)
				donePlaying = true;
		}
		
		if (player.isDead) {
			donePlaying = true;
		} else {
			xPosF = (float) player.posX;
			yPosF = (float) player.posY;
			zPosF = (float) player.posZ;
			
			distance = MathHelper.clamp(distance + 0.0025F, 0.0F, 1.0F);
			volume = 1.0F; //XXX is this needed?
		}
	}
}