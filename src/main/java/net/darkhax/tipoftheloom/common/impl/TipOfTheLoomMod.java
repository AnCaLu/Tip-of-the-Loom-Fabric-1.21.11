package net.darkhax.tipoftheloom.common.impl;

import net.darkhax.tipoftheloom.common.impl.Config;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.entity.BannerPattern;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TipOfTheLoomMod {

    public static final String MOD_ID = "tipoftheloom";
    public static final String MOD_NAME = "TipOfTheLoom";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    private static final Config CONFIG = new Config();
    private static final Map<String, String> MOD_NAMES = new HashMap<>();

    public static void getPatternTooltips(Holder<BannerPattern> pattern, boolean isSelected, DyeItem dye, List<Component> tooltip, TooltipFlag flags) {
        final Config config = CONFIG;
        if (config.enabled && (!isSelected || config.show_on_selected_pattern)) {
            // Display Name
            tooltip.add(Component.translatable(pattern.value().translationKey() + "." + dye.getDyeColor().getName()));
            pattern.unwrapKey().ifPresent(key -> {
                // Debug ID
                if (config.debug_id.enabled && (flags.isAdvanced() || !config.debug_id.require_advanced_mode)) {
                    tooltip.add(Component.literal(key.identifier().toString()).withStyle(config.debug_id.display_style));
                }
                // Mod Name
				if (config.mod_name.enabled && (config.mod_name.display_on_vanilla_patterns || !"minecraft".equals(key.identifier().getNamespace()))) {
					tooltip.add(Component.literal(getModName(key.identifier().getNamespace())).withStyle(config.mod_name.display_style));
				}
            });
        }
    }

	private static String getModName(String namespace) {
		return namespace;
	}
}