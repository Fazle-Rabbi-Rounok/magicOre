package com.magicore;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.magicore.config.ConfigManager;
import com.magicore.event.OreBreakListener;
public class MagicOre implements ModInitializer {

    public static final String MOD_ID = "magicore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
   public void onInitialize() {

    LOGGER.info("====================================");
    LOGGER.info("MagicOre v1 is starting...");

    ConfigManager.initialize();

    LOGGER.info("Registering events...");

OreBreakListener.register();

    LOGGER.info("MagicOre loaded successfully!");
    LOGGER.info("====================================");
}


    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
