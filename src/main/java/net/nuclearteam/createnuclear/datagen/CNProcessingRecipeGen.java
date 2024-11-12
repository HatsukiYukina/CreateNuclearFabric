package net.nuclearteam.createnuclear.datagen;

import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.nuclearteam.createnuclear.datagen.recipe.compacting.CNCompactingRecipeGen;
import net.nuclearteam.createnuclear.datagen.recipe.crushing.CNCrushingRecipeGen;
import net.nuclearteam.createnuclear.datagen.recipe.enriched.CNEnrichedRecipeGen;
import net.nuclearteam.createnuclear.datagen.recipe.mixing.CNMixingRecipeGen;
import net.nuclearteam.createnuclear.datagen.recipe.pressing.CNPressingRecipeGen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class CNProcessingRecipeGen {

    protected static final List<ProcessingRecipeGen> GENERATORS = new ArrayList<>();

    public static DataProvider registerAll(FabricDataOutput output) {
        GENERATORS.add(new CNCompactingRecipeGen(output));
        GENERATORS.add(new CNCrushingRecipeGen(output));
        GENERATORS.add(new CNEnrichedRecipeGen(output));
        GENERATORS.add(new CNMixingRecipeGen(output));
        GENERATORS.add(new CNPressingRecipeGen(output));

        return new DataProvider() {

            @Override
            public String getName() {
                return "CreateNuclear's Processing Recipes";
            }

            @Override
            public CompletableFuture<?> run(CachedOutput output) {
                return CompletableFuture.allOf(GENERATORS.stream()
                        .map(gen -> gen.run(output))
                        .toArray(CompletableFuture[]::new));
            }
        };
    }
}
