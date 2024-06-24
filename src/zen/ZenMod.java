package zen;

import arc.*;
import arc.util.*;
import mindustry.Vars;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class ZenMod extends Mod{

    public ZenMod(){
        Events.on(ClientLoadEvent.class, e -> {
            StartSplash.build(Vars.ui.menuGroup);
            StartSplash.show();
        });
    }

    @Override
    public void loadContent(){}
}
