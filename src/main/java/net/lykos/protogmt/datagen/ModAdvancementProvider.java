package net.lykos.protogmt.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.lykos.protogmt.ProtoGMT;
import assets.protogmt.models.block.item.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.OnKilledCriterion;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;


public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {

        Advancement rootAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.MITHRIL_INGOT),
                        Text.literal("Abyss Magic"), Text.literal("The very first step into the Abyss."),
                        new Identifier(ProtoGMT.MOD_ID, "textures/block/mithril_pure_block.png"), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_mithril_ingot", InventoryChangedCriterion.Conditions.items(ModItems.MITHRIL_INGOT))
                .build(consumer, ProtoGMT.MOD_ID + ":protoelestia");

        Advancement cheeseAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.HOLY_CHEESE),
                        Text.literal("Cheese."), Text.literal("Cheese."),
                        new Identifier(ProtoGMT.MOD_ID, "textures/block/mithril_pure_block.png"), AdvancementFrame.CHALLENGE,
                        true, true, true))
                .criterion("has_mithril_ingot", InventoryChangedCriterion.Conditions.items(ModItems.HOLY_CHEESE))
                .parent(rootAdvancement)
                .build(consumer, ProtoGMT.MOD_ID + ":cheese");


        Advancement scanAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.ETHER_SCANNER),
                        Text.literal("Ether Scanner"), Text.literal("Shiny rock are you here ?"),
                        new Identifier(ProtoGMT.MOD_ID, "textures/block/mithril_pure_block.png"), AdvancementFrame.GOAL,
                        true, true, false))
                .criterion("has_mithril_ingot", InventoryChangedCriterion.Conditions.items(ModItems.ETHER_SCANNER))
                .parent(rootAdvancement)
                .build(consumer, ProtoGMT.MOD_ID + ":ether_scanner");


        Advancement GettingEtherAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.ETHER),
                        Text.literal("The First Mana Stone"), Text.literal("You have collected the first ever mana stone know to man."),
                        new Identifier(ProtoGMT.MOD_ID, "textures/block/mithril_pure_block.png"), AdvancementFrame.CHALLENGE,
                        true, true, false))
                .criterion("has_mithril_ingot", InventoryChangedCriterion.Conditions.items(ModItems.ETHER))
                .parent(scanAdvancement)
                .build(consumer, ProtoGMT.MOD_ID + ":ether");

        Advancement BruhMomentAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.ETHER_HOE),
                        Text.literal("Bruh."), Text.literal("You wasted. The only type of mana stone obtainable in this realm... For a F**king HOE ?! Come on please... Netherite was enough already. Please stop. Consider your life choices." + " -Dearly your Narrator Bacharu"),
                        new Identifier(ProtoGMT.MOD_ID, "textures/block/mithril_pure_block.png"), AdvancementFrame.CHALLENGE,
                        true, true, true))
                .criterion("has_mithril_ingot", InventoryChangedCriterion.Conditions.items(ModItems.ETHER_HOE))
                .parent(GettingEtherAdvancement)
                .build(consumer, ProtoGMT.MOD_ID + ":ether_hoe");


        Advancement EtherUpgradeSwordAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Text.literal("Ether Upgrade !"), Text.literal("You have upgraded your Netherite Tools and Armor !"),
                        new Identifier(ProtoGMT.MOD_ID, "textures/block/mithril_pure_block.png"), AdvancementFrame.CHALLENGE,
                        true, true, false))
                .criterion("has_ether_sword", InventoryChangedCriterion.Conditions.items(ModItems.ETHER_SWORD))
                .criterion("has_ether_hoe", InventoryChangedCriterion.Conditions.items(ModItems.ETHER_HOE))
                .criterion("has_ether_axe", InventoryChangedCriterion.Conditions.items(ModItems.ETHER_AXE))
                .criterion("has_ether_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.ETHER_PICKAXE))
                .criterion("has_ether_shovel", InventoryChangedCriterion.Conditions.items(ModItems.ETHER_SHOVEL))
                .criterion("has_ether_helmet", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_ETHER_UPGRADED_HELMET))
                .criterion("has_ether_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_ETHER_UPGRADED_CHESTPLATE))
                .criterion("has_ether_leggings", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_ETHER_UPGRADED_LEGGINGS))
                .criterion("has_ether_boots", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_ETHER_UPGRADED_BOOTS))
                .parent(GettingEtherAdvancement)
                .requirements(new String[][]{
                        {"has_ether_sword", "has_ether_axe", "has_ether_pickaxe",
                                "has_ether_shovel","has_ether_hoe", "has_ether_helmet", "has_ether_chestplate",
                                "has_ether_leggings", "has_ether_boots"}
                })

                        .parent(GettingEtherAdvancement)
                .build(consumer, ProtoGMT.MOD_ID + ":ether_upgrade");

                Advancement MithrilUpgradeSwordAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Text.literal("Slightly better than Netherite !"), Text.literal("You Fools This Isn't My Final Form !"),
                        new Identifier(ProtoGMT.MOD_ID, "textures/block/mithril_pure_block.png"), AdvancementFrame.GOAL,
                        true, true, false))
                .criterion("has_mithril_sword", InventoryChangedCriterion.Conditions.items(ModItems.MITHRIL_SWORD))
                .criterion("has_mithril_axe", InventoryChangedCriterion.Conditions.items(ModItems.MITHRIL_AXE))
                .criterion("has_mithril_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.MITHRIL_PICKAXE))
                .criterion("has_mithril_shovel", InventoryChangedCriterion.Conditions.items(ModItems.MITHRIL_SHOVEL))
                .criterion("has_mithril_hoe", InventoryChangedCriterion.Conditions.items(ModItems.MITHRIL_HOE))
                .parent(rootAdvancement)
                .requirements(new String[][]{
                        {"has_mithril_sword", "has_mithril_axe", "has_mithril_pickaxe",
                                "has_mithril_shovel", "has_mithril_hoe"}
                })

                        .parent(GettingEtherAdvancement)
                .build(consumer, ProtoGMT.MOD_ID + ":mithril_upgrade");

        Advancement DudeNoPleaseAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.MITHRIL_HOE),
                        Text.literal("Eh... Ok i guess ?"), Text.literal("Ok i get it but please don't go further than that with a hoe it is not worth it..." + " -Your Narrator Bacharu"),
                        new Identifier(ProtoGMT.MOD_ID, "textures/block/mithril_pure_block.png"), AdvancementFrame.CHALLENGE,
                        true, true, true))
                .criterion("has_mithril_ingot", InventoryChangedCriterion.Conditions.items(ModItems.MITHRIL_HOE))
                .parent(rootAdvancement)
                .build(consumer, ProtoGMT.MOD_ID + ":mithril_hoe");




        Advancement ApostleOfGreedAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.ETHER_TRIM_UPGRADE),
                        Text.literal("Apostle of Greed"), Text.literal("An armor made from the very First Mana Stone in existence. For the common folks it might be as powerful as it seems. But trust me it can get even more crazy and powerful. " +
                        "-Bacharu"),
                        new Identifier(ProtoGMT.MOD_ID, "textures/block/mithril_pure_block.png"), AdvancementFrame.CHALLENGE,
                        true, true, true))
                .criterion("has_ether_armor", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_ETHER_UPGRADED_HELMET, ModItems.NETHERITE_ETHER_UPGRADED_BOOTS, ModItems.NETHERITE_ETHER_UPGRADED_CHESTPLATE, ModItems.NETHERITE_ETHER_UPGRADED_LEGGINGS))
                .parent(GettingEtherAdvancement)
                .build(consumer, ProtoGMT.MOD_ID + ":ether_greed");






        Advancement wardenkillAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items.SCULK_SHRIEKER),
                        Text.literal("The Guardian of the Portal"), Text.literal("You have slayed the once peaceful and calm beast. Congrats."),
                        new Identifier(ProtoGMT.MOD_ID, "textures/block/mithril_pure_block.png"), AdvancementFrame.GOAL,
                        true, true, false))
                .criterion("has_mithril_ingot", OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create().type(EntityType.WARDEN).build()))
                .parent(rootAdvancement)
                .build(consumer, ProtoGMT.MOD_ID + ":wardenkill");
        Advancement HeartOfTheBeastAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.CORRUPTED_WARDEN_HEART),
                        Text.literal("Heart of the Beast"), Text.literal("You were lucky enough to obtain the Warden Heart."),
                        new Identifier(ProtoGMT.MOD_ID, "textures/block/mithril_pure_block.png"), AdvancementFrame.CHALLENGE,
                        true, true, false))
                .criterion("has_mithril_ingot", InventoryChangedCriterion.Conditions.items(ModItems.CORRUPTED_WARDEN_HEART))
                .parent(wardenkillAdvancement)
                .build(consumer, ProtoGMT.MOD_ID + ":wardenheart");
        Advancement HeartOfMrBeastAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.PURIFIED_WARDEN_HEART),
                        Text.literal("Taming the beast."), Text.literal("Uh... So i guess the Warden like Cheese ?"),
                        new Identifier(ProtoGMT.MOD_ID, "textures/block/mithril_pure_block.png"), AdvancementFrame.CHALLENGE,
                        true, true, false))
                .criterion("has_mithril_ingot", InventoryChangedCriterion.Conditions.items(ModItems.PURIFIED_WARDEN_HEART))
                .parent(HeartOfTheBeastAdvancement)
                .build(consumer, ProtoGMT.MOD_ID + ":mrbeastheart");
        Advancement TheKeyAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.THE_KEY),
                        Text.literal("The Key to the Soul"), Text.literal("All those challenge yet your soul never weavered... As the narrator of your story i'll tell you that you are worthy of whatever come next."),
                        new Identifier(ProtoGMT.MOD_ID, "textures/block/mithril_pure_block.png"), AdvancementFrame.CHALLENGE,
                        true, true, true))
                .criterion("has_mithril_ingot", InventoryChangedCriterion.Conditions.items(ModItems.THE_KEY))
                .parent(HeartOfMrBeastAdvancement)
                .build(consumer, ProtoGMT.MOD_ID + ":dakey");




        Advancement youmonsterAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.ALLEY_SOUL),
                        Text.literal("You monster !"), Text.literal("You have killed an Allay, Congratulation now pray for your sins."),
                        new Identifier(ProtoGMT.MOD_ID, "textures/block/mithril_pure_block.png"), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_mithril_ingot", OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create().type(EntityType.ALLAY).build()))
                .parent(rootAdvancement)
                .build(consumer, ProtoGMT.MOD_ID + ":allaykill");
        Advancement thankyouAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.VEX_SOUL),
                        Text.literal("The Annoying Child"), Text.literal("You have killed a Vex, Congratulation. And thank you. I hate them."),
                        new Identifier(ProtoGMT.MOD_ID, "textures/block/mithril_pure_block.png"), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_mithril_ingot", OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create().type(EntityType.VEX).build()))
                .parent(youmonsterAdvancement)
                .build(consumer, ProtoGMT.MOD_ID + ":vexkill");


    }
}
