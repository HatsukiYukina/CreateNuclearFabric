package net.nuclearteam.createnuclear.menu;

import com.tterrag.registrate.builders.MenuBuilder;
import com.tterrag.registrate.util.entry.MenuEntry;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.nuclearteam.createnuclear.CreateNuclear;
import net.nuclearteam.createnuclear.multiblock.configuredItem.ConfiguredReactorItemMenu;
import net.nuclearteam.createnuclear.multiblock.configuredItem.ConfiguredReactorItemScreen;
import net.nuclearteam.createnuclear.multiblock.input.ReactorInputMenu;
import com.tterrag.registrate.builders.MenuBuilder.ScreenFactory;
import com.tterrag.registrate.builders.MenuBuilder.ForgeMenuFactory;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.nuclearteam.createnuclear.multiblock.input.ReactorInputScreen;

public class CNMenus {
    //public static final MenuEntry<ReactorControllerMenu> REACTOR_CONTROLLER = menu("reactor_controller", ReactorControllerMenu::new, ReactorControllerScreen::new);
    public static final MenuEntry<ConfiguredReactorItemMenu> CONFIGURED_REACTOR_MENU = menu("configured_reactor_menu", ConfiguredReactorItemMenu::new, () -> ConfiguredReactorItemScreen::new);
    public static final MenuEntry<ReactorInputMenu> SLOT_ITEM_STORAGE = menu("slot_item_menu", ReactorInputMenu::new, () -> ReactorInputScreen::new);

    private static <C extends AbstractContainerMenu, S extends Screen & MenuAccess<C>> MenuEntry<C> menu(String name, ForgeMenuFactory<C> factory, NonNullSupplier<ScreenFactory<C, S>> screenFactory) {
        return CreateNuclear.REGISTRATE.menu(name, factory, screenFactory).register();
    }

    public static void register() {}
}
