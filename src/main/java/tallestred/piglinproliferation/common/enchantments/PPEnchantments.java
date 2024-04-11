package tallestred.piglinproliferation.common.enchantments;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import tallestred.piglinproliferation.PiglinProliferation;
import tallestred.piglinproliferation.common.items.BucklerItem;

public class PPEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(Registries.ENCHANTMENT, PiglinProliferation.MODID);
    public static final DeferredHolder<Enchantment, TurningEnchantment> TURNING = ENCHANTMENTS.register("turning", () -> new TurningEnchantment(Enchantment.Rarity.COMMON, EquipmentSlot.MAINHAND));
    public static final DeferredHolder<Enchantment, BangEnchantment> BANG = ENCHANTMENTS.register("bang", () -> new BangEnchantment(Enchantment.Rarity.COMMON, EquipmentSlot.MAINHAND));

    public static final EnchantmentCategory BUCKLER = EnchantmentCategory.create("buckler", (item) -> (item instanceof BucklerItem));

    public static boolean hasBucklerEnchantsOnHands(LivingEntity player, Enchantment... enchantments) {
        InteractionHand hand = player.getMainHandItem().getItem() instanceof BucklerItem ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
        ItemStack stack = player.getItemInHand(hand);
        for (Enchantment enchantment : enchantments)
            if (stack.getEnchantmentLevel(enchantment) > 0)
                return true;
        return false;
    }

    public static int getBucklerEnchantsOnHands(Enchantment enchantment, LivingEntity player) {
        InteractionHand hand = player.getMainHandItem().getItem() instanceof BucklerItem ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
        ItemStack stack = player.getItemInHand(hand);
        return stack.getEnchantmentLevel(enchantment);
    }
}
