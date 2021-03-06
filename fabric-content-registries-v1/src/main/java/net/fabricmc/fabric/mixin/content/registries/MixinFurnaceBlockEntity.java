/*
 * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.fabric.mixin.content.registries;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.item.ItemStack;

import net.fabricmc.fabric.api.content.registry.v1.FuelRegistry;

@Mixin(FurnaceBlockEntity.class)
public class MixinFurnaceBlockEntity {
	@Inject(at = @At("HEAD"), method = "method_1144", cancellable = true)
	private static void registerFuels(ItemStack stack, CallbackInfoReturnable<Integer> info) {
		if (stack == null) return;
		Integer value = FuelRegistry.INSTANCE.getFuelMap().get(stack.getItem());

		if (value != null) {
			info.setReturnValue(value);
		}
	}
}
