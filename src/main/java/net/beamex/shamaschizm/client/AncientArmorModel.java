package net.beamex.shamaschizm.client;

import net.beamex.shamaschizm.Shamaschizm;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;

/** Humanoid-bound versions of the four supplied Blockbench armor models. */
public final class AncientArmorModel extends HumanoidModel<HumanoidRenderState> {
    public static final ModelLayerLocation HELMET_LAYER = layer("ancient_helmet");
    public static final ModelLayerLocation CHESTPLATE_LAYER = layer("ancient_chestplate");
    public static final ModelLayerLocation LEGGINGS_LAYER = layer("ancient_leggings");
    public static final ModelLayerLocation BOOTS_LAYER = layer("ancient_boots");
    public static final ModelLayerLocation BABY_HELMET_LAYER = layer("ancient_helmet_baby");
    public static final ModelLayerLocation BABY_CHESTPLATE_LAYER = layer("ancient_chestplate_baby");
    public static final ModelLayerLocation BABY_LEGGINGS_LAYER = layer("ancient_leggings_baby");
    public static final ModelLayerLocation BABY_BOOTS_LAYER = layer("ancient_boots_baby");

    public AncientArmorModel(ModelPart root) {
        super(root);
    }

    private static ModelLayerLocation layer(String path) {
        return new ModelLayerLocation(Identifier.fromNamespaceAndPath(Shamaschizm.MOD_ID, path), "main");
    }

    private static Parts blankHumanoid() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
        head.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
        root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
        root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
        root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
        root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
        root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
        return new Parts(mesh, root);
    }

    public static LayerDefinition createHelmetLayer() {
        Parts p = blankHumanoid();
        p.root().addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.75F))
                .texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.ZERO)
                .addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
        return LayerDefinition.create(p.mesh(), 64, 64);
    }

    public static LayerDefinition createChestplateLayer() {
        Parts p = blankHumanoid();
        p.root().addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.99F))
                .texOffs(0, 44).addBox(-9.0F, -1.0F, -3.0F, 18.0F, 14.0F, 6.0F, new CubeDeformation(-0.25F))
                .texOffs(34, 40).addBox(5.0F, 11.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F))
                .texOffs(34, 40).addBox(-7.0F, 11.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F))
                .texOffs(34, 40).addBox(6.5F, 11.7F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.6F))
                .texOffs(34, 40).addBox(-8.5F, 11.7F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.ZERO);
        p.root().addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror()
                .addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)).mirror(false),
                PartPose.offset(5.0F, 2.0F, 0.0F));
        p.root().addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16)
                .addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)),
                PartPose.offset(-5.0F, 2.0F, 0.0F));
        return LayerDefinition.create(p.mesh(), 64, 64);
    }

    public static LayerDefinition createLeggingsLayer() {
        Parts p = blankHumanoid();
        p.root().addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16)
                .addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.ZERO);
        p.root().addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror()
                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false)
                .texOffs(0, 6).addBox(-0.9F, 3.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.65F))
                .texOffs(54, 0).addBox(-0.9F, 2.0F, -3.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)),
                PartPose.offset(1.9F, 12.0F, 0.0F));
        p.root().addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16)
                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F))
                .texOffs(40, 22).addBox(-2.1F, 3.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.65F))
                .texOffs(54, 6).addBox(-2.1F, 2.0F, -3.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)),
                PartPose.offset(-1.9F, 12.0F, 0.0F));
        return LayerDefinition.create(p.mesh(), 64, 32);
    }

    public static LayerDefinition createBootsLayer() {
        Parts p = blankHumanoid();
        p.root().addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror()
                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).mirror(false)
                .texOffs(42, 37).addBox(-1.9F, 0.0F, -3.0F, 5.0F, 7.0F, 6.0F),
                PartPose.offset(1.9F, 12.0F, 0.0F));
        p.root().addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16)
                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F))
                .texOffs(10, 31).addBox(-3.1F, 0.0F, -3.0F, 5.0F, 7.0F, 6.0F),
                PartPose.offset(-1.9F, 12.0F, 0.0F));
        return LayerDefinition.create(p.mesh(), 64, 64);
    }

    public static LayerDefinition createBabyHelmetLayer() {
        return createHelmetLayer().apply(HumanoidModel.BABY_TRANSFORMER);
    }

    public static LayerDefinition createBabyChestplateLayer() {
        return createChestplateLayer().apply(HumanoidModel.BABY_TRANSFORMER);
    }

    public static LayerDefinition createBabyLeggingsLayer() {
        return createLeggingsLayer().apply(HumanoidModel.BABY_TRANSFORMER);
    }

    public static LayerDefinition createBabyBootsLayer() {
        return createBootsLayer().apply(HumanoidModel.BABY_TRANSFORMER);
    }

    private record Parts(MeshDefinition mesh, PartDefinition root) {}
}
