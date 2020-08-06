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

package net.fabricmc.fabric.impl.event;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.client.*;

@Environment(EnvType.CLIENT)
public class LegacyClientEventInvokers implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> ClientTickCallback.EVENT.invoker().tick(client));
		ClientLifecycleEvents.CLIENT_STARTED.register(client -> ClientStartCallback.EVENT.invoker().onStartClient(client));
		ClientLifecycleEvents.CLIENT_STOPPING.register(client -> ClientStopCallback.EVENT.invoker().onStopClient(client));
		ClientLifecycleEvents.OUT_OF_MEMORY.register(client -> OutOfMemoryCallback.EVENT.invoker().onOutOfMemoryError(client));
		ClientLifecycleEvents.SERVER_PUBLISHED.register((client, gameMode, cheats, levelInfo) -> LanServerPublishedCallback.EVENT.invoker().onServerPublished(client, gameMode, cheats, levelInfo));
	}
}
