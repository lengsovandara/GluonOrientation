package fr.cashmag;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.CMOrientationService;
import com.gluonhq.charm.down.plugins.OrientationService;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class OrientationTestView extends View {

    public OrientationTestView() {
        
        Label label = new Label("Hello JavaFX World!");

        Button button = new Button("Change the World!");
        button.setGraphic(new Icon(MaterialDesignIcon.LANGUAGE));
        button.setOnAction(e -> {
            //label.setText("Hello JavaFX Universe!");
            Services.get(CMOrientationService.class ).ifPresent( o -> {
                Orientation orientation = Services.get( OrientationService.class )
                                                  .flatMap(OrientationService::getOrientation)
                                                  .orElse(Orientation.HORIZONTAL);

                if (orientation == Orientation.VERTICAL) {
                    o.coerceOrientation( Orientation.HORIZONTAL );
                } else {
                    //o.releaseOrientation();
                    o.coerceOrientation( Orientation.VERTICAL );
                }
            } );
        });
        
        VBox controls = new VBox(15.0, label, button);
        controls.setAlignment(Pos.CENTER);
        
        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> System.out.println("Menu")));
        appBar.setTitleText("Basic View");
        appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> System.out.println("Search")));
    }
    
}
