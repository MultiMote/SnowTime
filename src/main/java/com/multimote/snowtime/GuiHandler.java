package com.multimote.snowtime;


import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import org.lwjgl.opengl.GL11;

import java.util.Random;

/**
 * Created by MultiMote on 01.11.2014.
 */

public class GuiHandler {
    private static ResourceLocation snow = new ResourceLocation("snowtime:textures/snowdrops.png");
    public static Random RNG = new Random();
    private SnowDrop[] cloud;
    private int prevGuiW;

    public GuiHandler() {
        this.reset();
    }


    @SubscribeEvent
    public void drawGui(GuiScreenEvent.DrawScreenEvent.Post e) {
        if (Config.GUIS.contains(e.gui.getClass())) {
            if (this.prevGuiW != e.gui.width) {
                this.prevGuiW = e.gui.width;
                if (Config.RESET_ON_WIDTH_CHANGE) this.reset();
            }
            this.drawScreen(e.gui.width, e.gui.height, e.mouseX, e.mouseY);
        }
    }

    @SubscribeEvent
    public void openGui(GuiOpenEvent e) {
        if (e.gui == null) return;
        if (Config.RESET_SNOW) this.reset();
    }

    public void drawScreen(int width, int height, int mouseX, int mouseY) {
        Minecraft.getMinecraft().renderEngine.bindTexture(snow);
        GL11.glColor4f(1, 1, 1, 1);
        int i = 0;
        for (SnowDrop snowDrop : this.cloud) {
            if (snowDrop != null && !snowDrop.isDead()) {
                snowDrop.draw(width, height, mouseX, mouseY);
                if (snowDrop.isDead()) this.createSnowDropWithChance(i, width, height);
            } else {
                this.createSnowDropWithChance(i, width, height);
            }

            i++;
        }
    }

    private void createSnowDropWithChance(int id, int width, int height) {
        if (RNG.nextFloat() * 100F <= Config.DROP_CHANCE)
            this.cloud[id] = new SnowDrop(width, height);
    }

    private void reset() {
        this.cloud = new SnowDrop[Config.MAX_SNOWDROPS];
    }
}
