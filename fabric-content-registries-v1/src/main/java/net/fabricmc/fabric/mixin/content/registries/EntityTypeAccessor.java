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

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;

@Mixin(EntityType.class)
public interface EntityTypeAccessor {
	@Accessor("NAME_CLASS_MAP")
	Map<String, Class<? extends Entity>> getNameClassMap();

	@Accessor("CLASS_NAME_MAP")
	Map<Class<? extends Entity>, String> getClassNameMap();

	@Accessor("ID_CLASS_MAP")
	Map<Integer, Class<? extends Entity>> getIdClassMap();

	@Accessor("CLASS_ID_MAP")
	Map<Class<? extends Entity>, Integer> getClassIdMap();

	@Accessor("NAME_ID_MAP")
	Map<String, Integer> getNameIdMap();

	@Invoker
	void invokeRegisterEntity(Class<? extends Entity> clazz, String name, int id);
}
