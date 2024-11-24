package com.talhanation.smallships.fabric.client;

import com.talhanation.smallships.client.model.*;
import com.talhanation.smallships.client.option.KeyEvent;
import com.talhanation.smallships.client.option.ModGameOptions;
import com.talhanation.smallships.client.renderer.entity.*;
import com.talhanation.smallships.network.fabric.ModPacketsImpl;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class ClientInitializer implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        com.talhanation.smallships.client.ClientInitializer.init();

        initRendererRegisterRenderers();

        initRendererRegisterLayerDefinitions();

        initRegisterKeyMappings();

        initRegisterTickEvents();

        initRegisterPacketReceivers();
    }

    private void initRendererRegisterRenderers() {
        EntityRendererRegistry.register(ModEntityTypes.CANNON_BALL, CannonBallRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.GROUND_CANNON, GroundCannonRenderer::new);

        EntityRendererRegistry.register(ModEntityTypes.COG, CogRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.BRIGG, BriggRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.GALLEY, GalleyRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.DRAKKAR, DrakkarRenderer::new);
    }

    private void initRendererRegisterLayerDefinitions() {
        EntityModelLayerRegistry.registerModelLayer(CannonBallModel.LAYER_LOCATION, CannonBallModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CannonModel.LAYER_LOCATION, CannonModel::createBodyLayer);

        EntityModelLayerRegistry.registerModelLayer(CogModel.LAYER_LOCATION, CogModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(BriggModel.LAYER_LOCATION, BriggModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(GalleyModel.LAYER_LOCATION, GalleyModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(DrakkarModel.LAYER_LOCATION, DrakkarModel::createBodyLayer);
    }

    private void initRegisterKeyMappings() {
        KeyBindingHelper.registerKeyBinding(ModGameOptions.SAIL_KEY);
        KeyBindingHelper.registerKeyBinding(ModGameOptions.ENTER_CANNON_BARREL_KEY);
    }

    private void initRegisterTickEvents() {
        ClientTickEvents.END_CLIENT_TICK.register(KeyEvent::onKeyInput);
    }

    private void initRegisterPacketReceivers() {
        ModPacketsImpl.registerClientReceivers();
    }
}
