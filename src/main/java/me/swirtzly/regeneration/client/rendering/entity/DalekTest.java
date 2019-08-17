package me.swirtzly.regeneration.client.rendering.entity;

import me.swirtzly.regeneration.OBJLoader;
import me.swirtzly.regeneration.Obj;
import me.swirtzly.regeneration.RegenerationMod;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Swirtzly
 * on 17/08/2019 @ 22:05
 */
public class DalekTest {


    public static Obj HEAD = OBJLoader.INSTANCE.loadModel(getModelInput(new ResourceLocation(RegenerationMod.MODID, "models/test/swd_head.obj")));
    public static Obj BASE = OBJLoader.INSTANCE.loadModel(getModelInput(new ResourceLocation(RegenerationMod.MODID, "models/test/swd_base.obj")));
    public static Obj GUN = OBJLoader.INSTANCE.loadModel(getModelInput(new ResourceLocation(RegenerationMod.MODID, "models/test/swd_gun.obj")));


    public static InputStream getModelInput(ResourceLocation location) {
        try {
            return Minecraft.getMinecraft().getResourceManager().getResource(location).getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
