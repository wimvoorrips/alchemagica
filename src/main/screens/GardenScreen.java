package main.screens;

import main.interfaces.GameEntity;
import main.items.ingredients.LongGrass;
import main.witch.Witch;

public class GardenScreen extends Screen {
    public GardenScreen(Witch witch){
        super();
        addEntities(witch);
    }

    private void addEntities(Witch witch){
        Locationchangebar locationchangebar = new Locationchangebar(0,0, this.width, 100);
        addEntity(locationchangebar);


        int x = 270;
        int y = 100;
        for(int i = 0; i < 4; i++){
            GardenPlot gardenPlot = new GardenPlot(witch, x, y);
            gardenPlot.setIngredient(new LongGrass(0,0));
            addEntity((GameEntity) gardenPlot);
            x -= 90;
            y += 90;
        }

        x = 610;
        y = 100;
        for(int i = 0; i < 4; i++){
            GardenPlot gardenPlot = new GardenPlot(witch, x, y);
            gardenPlot.setIngredient(new LongGrass(0,0));
            gardenPlot.setFlipped(true);
            addEntity((GameEntity) gardenPlot);
            x += 90;
            y += 90;
        }

    }
}
