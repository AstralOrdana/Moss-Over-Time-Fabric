package com.ordana.immersive_weathering.util;

import com.ordana.immersive_weathering.reg.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;

import java.util.function.Supplier;

public class TemperatureManager {

    public static boolean snowGrowthCanGrowSnowyBlock(BlockPos pos, Supplier<Holder<Biome>> biome) {
        return biome.get().value().coldEnoughToSnow(pos);
    }

    public static boolean canSnowMelt(BlockPos pos, Level level) {
        //warmEnoughToRain should be sufficient to turn back snowy blocks for season mods and works as intended where snow should melt if it rains.
        Holder<Biome> biome = level.getBiome(pos);
        return biome.value().warmEnoughToRain(pos);
    }

    public static boolean hasSandstorm(ServerLevel level, BlockPos pos) {
        return level.isRaining() && level.getBiome(pos).is(ModTags.HAS_SANDSTORM);
    }

    /*
     * Use Cases:
     *
     * Snowy blocks melting
     * Snowy blocks forming
     * Icicle melting
     * Icicle forming
     *
     */

}
