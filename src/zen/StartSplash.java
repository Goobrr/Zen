package zen;

import arc.Core;
import arc.math.Interp;
import arc.scene.Group;
import arc.scene.actions.Actions;
import arc.scene.event.Touchable;
import arc.scene.ui.layout.Table;
import mindustry.Vars;
import mindustry.gen.Tex;
import mindustry.ui.Styles;

public class StartSplash {
    private static Table logoTable, goobworksTable, cont;
    public static void build(Group group){
        group.fill(t -> {
            cont = t;
            t.touchable(() -> Touchable.enabled);
            t.setBackground(Styles.black);

            t.fill(w -> {
                goobworksTable = w;
                w.image(Core.atlas.find("zen-goobworks")).center().expand();
                w.setTransform(true);
            });

            t.fill(w -> {
                logoTable = w;
                w.image(Tex.logo).center().expand();
                w.setTransform(true);
            });
        });
    }

    public static void show(){
        cont.visible(() -> true);

        goobworksTable.actions(
                Actions.alpha(0f),
                Actions.delay(1f),
                Actions.fadeIn(1f, Interp.pow3Out),
                Actions.delay(3f),
                Actions.fadeOut(1f, Interp.pow3Out)
        );

        logoTable.actions(
                Actions.alpha(0f),
                Actions.delay(6.5f),
                Actions.fadeIn(1f, Interp.pow3Out),
                Actions.delay(3f),
                Actions.fadeOut(1f, Interp.pow3Out)
        );

        cont.actions(Actions.delay(12.5f, Actions.fadeOut(1f)), Actions.run(() -> {
            cont.visible(() -> false);
            cont.touchable(() -> Touchable.disabled);
        }));
    }
}
