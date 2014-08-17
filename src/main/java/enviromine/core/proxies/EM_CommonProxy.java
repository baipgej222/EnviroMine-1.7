package enviromine.core.proxies;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.RecipeSorter;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import enviromine.gui.UpdateNotification;
import enviromine.handlers.EM_EventManager;
import enviromine.handlers.EM_ServerScheduledTickHandler;
import enviromine.handlers.crafting.CamelPackIntegrationHandler;
import enviromine.handlers.crafting.CamelPackRefillHandler;

public class EM_CommonProxy
{
	public boolean isClient()
	{
		return false;
	}
	
	public boolean isOpenToLAN()
	{
		return false;
	}
	
	public void registerTickHandlers() {
		FMLCommonHandler.instance().bus().register(new EM_ServerScheduledTickHandler());
	}
	
	public void registerEventHandlers()
	{
		MinecraftForge.EVENT_BUS.register(new EM_EventManager());
		MinecraftForge.EVENT_BUS.register(new UpdateNotification());
		
		CamelPackRefillHandler tmp = new CamelPackRefillHandler();
		RecipeSorter.register("enviromine:packRefill", CamelPackRefillHandler.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");
		GameRegistry.addRecipe(tmp);
		FMLCommonHandler.instance().bus().register(tmp);
		
		CamelPackIntegrationHandler tmp2 = new CamelPackIntegrationHandler();
		RecipeSorter.register("enviromine:armorPack", CamelPackIntegrationHandler.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");
		GameRegistry.addRecipe(tmp2);
		FMLCommonHandler.instance().bus().register(tmp2);
	}
	
	public void preInit(FMLPreInitializationEvent event)
	{
		
	}
	
	public void init(FMLInitializationEvent event)
	{
		
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
