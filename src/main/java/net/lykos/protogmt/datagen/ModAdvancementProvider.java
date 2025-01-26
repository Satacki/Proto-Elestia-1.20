package net.lykos.protogmt.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.lykos.protogmt.ProtoGMT;
import net.lykos.protogmt.registry.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.KilledTrigger;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;


public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        new ItemStack(ModItems.MITHRIL_INGOT),
                        Component.literal("Abyss Magic"),
                        Component.literal("The very first step into the Abyss."),
                        ProtoGMT.id("textures/block/mithril_pure_block.png"),
                        FrameType.TASK,
                        true,
                        true,
                        false
                ))
                .addCriterion(
                        "has_mithril_ingot",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MITHRIL_INGOT)
                )
                .save(consumer, ProtoGMT.MOD_ID + ":" + ProtoGMT.MOD_ID);

        Advancement cheeseAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        new ItemStack(ModItems.HOLY_CHEESE),
                        Component.literal("Cheese."),
                        Component.literal("Cheese."),
                        ProtoGMT.id("textures/block/mithril_pure_block.png"),
                        FrameType.CHALLENGE,
                        true,
                        true,
                        true
                ))
                .addCriterion(
                        "has_mithril_ingot",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HOLY_CHEESE)
                )
                .parent(rootAdvancement)
                .save(consumer, ProtoGMT.MOD_ID + ":cheese");

        Advancement scanAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        new ItemStack(ModItems.ETHER_SCANNER),
                        Component.literal("Ether Scanner"),
                        Component.literal("Shiny rock are you here ?"),
                        ProtoGMT.id("textures/block/mithril_pure_block.png"),
                        FrameType.GOAL,
                        true,
                        true,
                        false
                ))
                .addCriterion(
                        "has_mithril_ingot",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ETHER_SCANNER)
                )
                .parent(rootAdvancement)
                .save(consumer, ProtoGMT.MOD_ID + ":ether_scanner");

        Advancement GettingEtherAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        new ItemStack(ModItems.ETHER),
                        Component.literal("The First Mana Stone"),
                        Component.literal("You have collected the first ever mana stone know to man."),
                        ProtoGMT.id("textures/block/mithril_pure_block.png"),
                        FrameType.CHALLENGE,
                        true,
                        true,
                        false
                ))
                .addCriterion("has_mithril_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ETHER))
                .parent(scanAdvancement)
                .save(consumer, ProtoGMT.MOD_ID + ":ether");

        Advancement BruhMomentAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        new ItemStack(ModItems.ETHER_HOE),
                        Component.literal("Bruh."),
                        Component.literal(
                                "You wasted. The only type of mana stone obtainable in this realm... For a F**king HOE ?! Come on please... Netherite was enough already. Please stop. Consider your life choices." +
                                " -Dearly your Narrator Bacharu"),
                        ProtoGMT.id("textures/block/mithril_pure_block.png"),
                        FrameType.CHALLENGE,
                        true,
                        true,
                        true
                ))
                .addCriterion("has_mithril_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ETHER_HOE))
                .parent(GettingEtherAdvancement)
                .save(consumer, ProtoGMT.MOD_ID + ":ether_hoe");

        Advancement EtherUpgradeSwordAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Component.literal("Ether Upgrade !"),
                        Component.literal("You have upgraded your Netherite Tools and Armor !"),
                        ProtoGMT.id("textures/block/mithril_pure_block.png"),
                        FrameType.CHALLENGE,
                        true,
                        true,
                        false
                ))
                .addCriterion("has_ether_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ETHER_SWORD))
                .addCriterion("has_ether_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ETHER_HOE))
                .addCriterion("has_ether_axe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ETHER_AXE))
                .addCriterion(
                        "has_ether_pickaxe",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ETHER_PICKAXE)
                )
                .addCriterion(
                        "has_ether_shovel",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ETHER_SHOVEL)
                )
                .addCriterion(
                        "has_ether_helmet",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ETHER_UPGRADED_HELMET)
                )
                .addCriterion(
                        "has_ether_chestplate",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ETHER_UPGRADED_CHESTPLATE)
                )
                .addCriterion(
                        "has_ether_leggings",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ETHER_UPGRADED_LEGGINGS)
                )
                .addCriterion(
                        "has_ether_boots",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ETHER_UPGRADED_BOOTS)
                )
                .parent(GettingEtherAdvancement)
                .requirements(new String[][] {
                        {
                                "has_ether_sword",
                                "has_ether_axe",
                                "has_ether_pickaxe",
                                "has_ether_shovel",
                                "has_ether_hoe",
                                "has_ether_helmet",
                                "has_ether_chestplate",
                                "has_ether_leggings",
                                "has_ether_boots"
                        }
                })

                .parent(GettingEtherAdvancement)
                .save(consumer, ProtoGMT.MOD_ID + ":ether_upgrade");

        Advancement MithrilUpgradeSwordAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Component.literal("Slightly better than Netherite !"),
                        Component.literal("You Fools This Isn't My Final Form !"),
                        ProtoGMT.id("textures/block/mithril_pure_block.png"),
                        FrameType.GOAL,
                        true,
                        true,
                        false
                ))
                .addCriterion(
                        "has_mithril_sword",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MITHRIL_SWORD)
                )
                .addCriterion("has_mithril_axe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MITHRIL_AXE))
                .addCriterion(
                        "has_mithril_pickaxe",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MITHRIL_PICKAXE)
                )
                .addCriterion(
                        "has_mithril_shovel",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MITHRIL_SHOVEL)
                )
                .addCriterion("has_mithril_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MITHRIL_HOE))
                .parent(rootAdvancement)
                .requirements(new String[][] {
                        {
                                "has_mithril_sword",
                                "has_mithril_axe",
                                "has_mithril_pickaxe",
                                "has_mithril_shovel",
                                "has_mithril_hoe"
                        }
                })

                .parent(GettingEtherAdvancement)
                .save(consumer, ProtoGMT.MOD_ID + ":mithril_upgrade");

        Advancement DudeNoPleaseAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        new ItemStack(ModItems.MITHRIL_HOE),
                        Component.literal("Eh... Ok i guess ?"),
                        Component.literal(
                                "Ok i get it but please don't go further than that with a hoe it is not worth it..." +
                                " -Your Narrator Bacharu"),
                        ProtoGMT.id("textures/block/mithril_pure_block.png"),
                        FrameType.CHALLENGE,
                        true,
                        true,
                        true
                ))
                .addCriterion(
                        "has_mithril_ingot",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MITHRIL_HOE)
                )
                .parent(rootAdvancement)
                .save(consumer, ProtoGMT.MOD_ID + ":mithril_hoe");

        Advancement ApostleOfGreedAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        new ItemStack(ModItems.ETHER_TRIM_UPGRADE),
                        Component.literal("Apostle of Greed"),
                        Component.literal(
                                "An armor made from the very First Mana Stone in existence. For the common folks it might be as powerful as it seems. But trust me it can get even more crazy and powerful. " +
                                "-Bacharu"),
                        ProtoGMT.id("textures/block/mithril_pure_block.png"),
                        FrameType.CHALLENGE,
                        true,
                        true,
                        true
                ))
                .addCriterion(
                        "has_ether_armor",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ModItems.NETHERITE_ETHER_UPGRADED_HELMET,
                                ModItems.NETHERITE_ETHER_UPGRADED_BOOTS,
                                ModItems.NETHERITE_ETHER_UPGRADED_CHESTPLATE,
                                ModItems.NETHERITE_ETHER_UPGRADED_LEGGINGS
                        )
                )
                .parent(GettingEtherAdvancement)
                .save(consumer, ProtoGMT.MOD_ID + ":ether_greed");

        Advancement wardenkillAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        new ItemStack(Items.SCULK_SHRIEKER),
                        Component.literal("The Guardian of the Portal"),
                        Component.literal("You have slayed the once peaceful and calm beast. Congrats."),
                        ProtoGMT.id("textures/block/mithril_pure_block.png"),
                        FrameType.GOAL,
                        true,
                        true,
                        false
                ))
                .addCriterion(
                        "has_mithril_ingot",
                        KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity()
                                                                                 .of(EntityType.WARDEN)
                                                                                 .build())
                )
                .parent(rootAdvancement)
                .save(consumer, ProtoGMT.MOD_ID + ":wardenkill");

        Advancement HeartOfTheBeastAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        new ItemStack(ModItems.CORRUPTED_WARDEN_HEART),
                        Component.literal("Heart of the Beast"),
                        Component.literal("You were lucky enough to obtain the Warden Heart."),
                        ProtoGMT.id("textures/block/mithril_pure_block.png"),
                        FrameType.CHALLENGE,
                        true,
                        true,
                        false
                ))
                .addCriterion(
                        "has_mithril_ingot",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CORRUPTED_WARDEN_HEART)
                )
                .parent(wardenkillAdvancement)
                .save(consumer, ProtoGMT.MOD_ID + ":wardenheart");

        Advancement HeartOfMrBeastAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        new ItemStack(ModItems.PURIFIED_WARDEN_HEART),
                        Component.literal("Taming the beast."),
                        Component.literal("Uh... So i guess the Warden like Cheese ?"),
                        ProtoGMT.id("textures/block/mithril_pure_block.png"),
                        FrameType.CHALLENGE,
                        true,
                        true,
                        false
                ))
                .addCriterion(
                        "has_mithril_ingot",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PURIFIED_WARDEN_HEART)
                )
                .parent(HeartOfTheBeastAdvancement)
                .save(consumer, ProtoGMT.MOD_ID + ":mrbeastheart");

        Advancement TheKeyAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        new ItemStack(ModItems.THE_KEY),
                        Component.literal("The Key to the Soul"),
                        Component.literal(
                                "All those challenge yet your soul never weavered... As the narrator of your story i'll tell you that you are worthy of whatever come next."),
                        ProtoGMT.id("textures/block/mithril_pure_block.png"),
                        FrameType.CHALLENGE,
                        true,
                        true,
                        true
                ))
                .addCriterion("has_mithril_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.THE_KEY))
                .parent(HeartOfMrBeastAdvancement)
                .save(consumer, ProtoGMT.MOD_ID + ":dakey");


        Advancement youmonsterAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        new ItemStack(ModItems.ALLEY_SOUL),
                        Component.literal("You monster !"),
                        Component.literal(
                                "You have killed an Allay, Congratulation now pray for your sins."),
                        ProtoGMT.id("textures/block/mithril_pure_block.png"),
                        FrameType.TASK,
                        true,
                        true,
                        false
                ))
                .addCriterion(
                        "has_mithril_ingot",
                        KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity()
                                                                                 .of(EntityType.ALLAY)
                                                                                 .build())
                )
                .parent(rootAdvancement)
                .save(consumer, ProtoGMT.MOD_ID + ":allaykill");

        Advancement thankyouAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        new ItemStack(ModItems.VEX_SOUL),
                        Component.literal("The Annoying Child"),
                        Component.literal(
                                "You have killed a Vex, Congratulation. And thank you. I hate them."),
                        ProtoGMT.id("textures/block/mithril_pure_block.png"),
                        FrameType.TASK,
                        true,
                        true,
                        false
                ))
                .addCriterion(
                        "has_mithril_ingot",
                        KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity()
                                                                                 .of(EntityType.VEX)
                                                                                 .build())
                )
                .parent(youmonsterAdvancement)
                .save(consumer, ProtoGMT.MOD_ID + ":vexkill");


    }
}
