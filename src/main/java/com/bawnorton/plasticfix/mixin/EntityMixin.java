package com.bawnorton.plasticfix.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Entity.class)
public abstract class EntityMixin {
	@ModifyVariable(method = "setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V", at = @At("HEAD"), argsOnly = true)
	private Vec3 set0IfInf(Vec3 value) {
		if (Double.isInfinite(value.x) || Double.isInfinite(value.y) || Double.isInfinite(value.z)) {
			return Vec3.ZERO;
		}
		return value;
	}
}
