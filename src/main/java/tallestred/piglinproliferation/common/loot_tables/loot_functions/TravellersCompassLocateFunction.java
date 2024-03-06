package tallestred.piglinproliferation.common.loot_tables.loot_functions;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import tallestred.piglinproliferation.common.entities.PiglinTraveller;
import tallestred.piglinproliferation.common.items.TravellersCompassItem;
import tallestred.piglinproliferation.common.loot_tables.CompassLocateObject;
import tallestred.piglinproliferation.common.loot_tables.PPLootTables;

import java.util.*;

//TODO: Make this a predicate to be used with the function!!! Otherwise it'll fire in the wrong order
public class TravellersCompassLocateFunction extends LootItemConditionalFunction {
    public static final Codec<TravellersCompassLocateFunction> CODEC =  RecordCodecBuilder.create(
            builder -> commonFields(builder).apply(builder, TravellersCompassLocateFunction::new));

    TravellersCompassLocateFunction(List<LootItemCondition> pPredicates) {
        super(pPredicates);
    }

    @Override
    protected ItemStack run(ItemStack itemStack, LootContext lootContext) {
        if (itemStack.getItem() instanceof TravellersCompassItem compass) {
            if (lootContext.getParamOrNull(LootContextParams.THIS_ENTITY) instanceof PiglinTraveller traveller) {
                CompassLocateObject object = traveller.currentlyLocatedObject.getKey();
                BlockPos pos = traveller.currentlyLocatedObject.getValue();
                traveller.alreadyLocatedObjects.add(object);
                compass.addTags(lootContext.getLevel().dimension(), pos, itemStack.getOrCreateTag(), object.getLocation().getPath(), true);
            }
        }
        return itemStack;
    }

    @Override
    public LootItemFunctionType getType() {
        return PPLootTables.TRAVELLERS_COMPASS_LOCATION.get();
    }
}