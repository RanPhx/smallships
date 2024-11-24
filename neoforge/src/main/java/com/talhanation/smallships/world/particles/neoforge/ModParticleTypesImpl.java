package com.talhanation.smallships.world.particles.neoforge;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@SuppressWarnings({"unused", "InstantiationOfUtilityClass"})
public class ModParticleTypesImpl {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, SmallShipsMod.MOD_ID);

    static {
        new ModParticleTypes(); // This just statically loads, so the registrations happen directly after the DeferredRegister is assigned
    }

    public static @NotNull <T extends ParticleOptions> Supplier<ParticleType<T>> register(String string, ParticleType<T> particleType) {
        return PARTICLE_TYPES.register(string, () -> particleType);
    }
}