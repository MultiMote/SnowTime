package com.multimote.snowtime;

import cpw.mods.fml.client.GuiModList;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.achievement.GuiStats;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MultiMote on 01.11.2014.
 */
public class Config {

    /**
     * Максимальное число снежинок на экране.
     */
    public static final int MAX_SNOWDROPS = 150;

    /**
     * Шанс спавна снежинки, без этого снежинки появляются все сразу.
     * 0F - 100F
     */
    public static final float DROP_CHANCE = 0.8F;

    /**
     * Окна, в которых будет идти снег.
     */
    public static final List<Class<? extends GuiScreen>> GUIS;

    /**
     * Чистить экран при смене окна.
     */
    public static final boolean RESET_SNOW = false;

    /**
     * Чистить экран при смене ширины окна.
     */
    public static final boolean RESET_ON_WIDTH_CHANGE = true;

    /**
     * Вращать снежинку по оси Z.
     */
    public static final boolean Z_ROTATION = true;

    /**
     * Снежинки избегают курсора в этом радиусе (от курсора).
     */
    public static final int MOUSE_AURA_RADIUS = 50;

    static {
        GUIS = new ArrayList<Class<? extends GuiScreen>>();
        GUIS.add(GuiMainMenu.class);
        GUIS.add(GuiMultiplayer.class);
        GUIS.add(GuiSelectWorld.class);
        GUIS.add(GuiCreateWorld.class);
        GUIS.add(GuiLanguage.class);
        GUIS.add(GuiControls.class);
        GUIS.add(GuiScreenResourcePacks.class);
        GUIS.add(GuiScreenOptionsSounds.class);
        GUIS.add(ScreenChatOptions.class);
        GUIS.add(GuiStats.class);
        GUIS.add(GuiIngameMenu.class);
        GUIS.add(GuiModList.class);
        GUIS.add(GuiOptions.class);
        GUIS.add(GuiVideoSettings.class);
    }
}
