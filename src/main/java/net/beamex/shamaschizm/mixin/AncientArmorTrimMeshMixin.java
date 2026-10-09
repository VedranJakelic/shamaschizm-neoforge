package net.beamex.shamaschizm.mixin;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import net.beamex.shamaschizm.client.AncientArmorModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.OrderedSubmitNodeCollector;
import net.minecraft.client.renderer.entity.layers.EquipmentLayerRenderer;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
/** 26.2 uses TextureAtlasSprite and a crumbling-overlay argument, unlike 26.3. */
@Mixin(EquipmentLayerRenderer.class)
public abstract class AncientArmorTrimMeshMixin {
 @WrapOperation(method="renderLayers(Lnet/minecraft/client/resources/model/EquipmentClientInfo$LayerType;Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/client/model/Model;Ljava/lang/Object;Lnet/minecraft/world/item/ItemStack;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;ILnet/minecraft/resources/Identifier;II)V",
  at=@At(value="INVOKE",target="Lnet/minecraft/client/renderer/OrderedSubmitNodeCollector;submitModel(Lnet/minecraft/client/model/Model;Ljava/lang/Object;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/rendertype/RenderType;IIILnet/minecraft/client/renderer/texture/TextureAtlasSprite;ILnet/minecraft/client/renderer/feature/ModelFeatureRenderer$CrumblingOverlay;)V"),remap=false)
 private void shamaschizm$trimMesh(OrderedSubmitNodeCollector collector,Model<?> model,Object state,PoseStack poses,RenderType type,int light,int overlay,int color,TextureAtlasSprite sprite,int outline,ModelFeatureRenderer.CrumblingOverlay crumbling,Operation<Void> original) {
  if(model instanceof AncientArmorModel ancient && sprite!=null) {
   var id=sprite.contents().name();
   boolean ascent=id.getNamespace().equals("shamaschizm") && id.getPath().contains("/ascent");
   model=ancient.trimMesh(ascent);
  }
  original.call(collector,model,state,poses,type,light,overlay,color,sprite,outline,crumbling);
 }
}
