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

package net.fabricmc.fabric.mixin.event.interaction;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.ClickType;

@Mixin(ScreenHandler.class)
public class MixinScreenHandler {
	@Redirect(method = "method_30010", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;onStackClicked(Lnet/minecraft/screen/slot/Slot;Lnet/minecraft/util/ClickType;Lnet/minecraft/entity/player/PlayerInventory;)Z"))
	public boolean interceptOnStackClicked(ItemStack itemStack, Slot slot, ClickType clickType, PlayerInventory playerInventory) {
		return false;
	}

	@Redirect(method = "method_30010", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;onClicked(Lnet/minecraft/item/ItemStack;Lnet/minecraft/screen/slot/Slot;Lnet/minecraft/util/ClickType;Lnet/minecraft/entity/player/PlayerInventory;)Z"))
	public boolean interceptOnClicked(ItemStack itemStack, ItemStack other, Slot slot, ClickType clickType, PlayerInventory playerInventory) {
		return false;
	}
}
