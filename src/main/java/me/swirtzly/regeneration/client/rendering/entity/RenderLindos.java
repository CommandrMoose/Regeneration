package me.swirtzly.regeneration.client.rendering.entity;

import me.swirtzly.regeneration.OBJLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

import javax.annotation.Nullable;

public class RenderLindos extends Render<Entity> {

    private Vec3d primaryColor = new Vec3d(0.93F, 0.61F, 0.0F);
    private Vec3d secondaryColor = new Vec3d(1F, 0.5F, 0.18F);


    public RenderLindos(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks) {

        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.scale(0.5, 0.5, 0.5);
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("regeneration", "models/test/swd.png"));
        OBJLoader.INSTANCE.render(DalekTest.HEAD);
        GlStateManager.popMatrix();


        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.scale(0.5, 0.5, 0.5);
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("regeneration", "models/test/swd.png"));
        OBJLoader.INSTANCE.render(DalekTest.BASE);
        GlStateManager.popMatrix();


        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.scale(0.5, 0.5, 0.5);
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("regeneration", "models/test/swd.png"));
        OBJLoader.INSTANCE.render(DalekTest.GUN);
        GlStateManager.popMatrix();

        //  Minecraft mc = Minecraft.getMinecraft();
        //  Random rand = entity.world.rand;
        //  float f = 0.1F;
        //  for (int j = 0; j < 2; j++) {
        //      RenderUtil.setupRenderLightning();
        //      GlStateManager.translate(x, y + 0.20, z);
        //       GlStateManager.scale(0.9F, 0.9F, 0.9F);
        //       RenderItemOverride.makeGlowingBall(mc, f, rand, primaryColor, secondaryColor);
        //    }
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return null;
    }
}
