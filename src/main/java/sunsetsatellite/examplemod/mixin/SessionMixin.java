package sunsetsatellite.examplemod.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import com.mojang.minecraft.util.Session;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

/*
	!!! DO NOT REMOVE !!!
	THE GAME WILL NOT RUN IF THIS IS REMOVED!
*/

@Mixin(
	value = Session.class,
	remap = false
)
public class SessionMixin {

	@Inject(method = "fromString", at = @At("HEAD"))
	private static void preventCrashOnInit(String input, CallbackInfoReturnable<UUID> cir, @Local(name = "input") LocalRef<String> inputRef){
		if(input == null){
			inputRef.set("null");
		}
	}

}
