package net.darkhax.tipoftheloom.common.impl;

import net.minecraft.ChatFormatting;

public class Config {

    public boolean enabled = true;

    public boolean show_on_selected_pattern = true;

    public DebugId debug_id = new DebugId();

    public ModName mod_name = new ModName();


    public static class DebugId {

        public boolean enabled = false;

        public boolean require_advanced_mode = true;

        public ChatFormatting display_style = ChatFormatting.GRAY;
    }


    public static class ModName {

        public boolean enabled = true;

        public boolean display_on_vanilla_patterns = false;

        public ChatFormatting display_style = ChatFormatting.GRAY;
    }
}