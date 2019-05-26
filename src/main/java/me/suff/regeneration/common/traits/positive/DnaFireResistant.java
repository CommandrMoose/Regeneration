package me.suff.regeneration.common.traits.positive;

import me.suff.regeneration.common.capability.IRegeneration;
import me.suff.regeneration.common.traits.DnaHandler;
import net.minecraft.entity.player.EntityPlayer;

public class DnaFireResistant extends DnaHandler.IDna {

    public DnaFireResistant() {
        super("fire");
    }

	@Override
	public void onUpdate(IRegeneration cap) {
		EntityPlayer player = cap.getPlayer();
		if (player.isBurning() && cap.isDnaActive()) {
			player.extinguish();
		}
	}
	
	@Override
	public void onAdded(IRegeneration cap) {
	
	}
	
	@Override
	public void onRemoved(IRegeneration cap) {
	
	}

}
