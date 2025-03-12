package main.gameobjects;

import main.interfaces.Updatable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class GameObject extends JComponent implements GameObjectInterface {

    protected java.util.List<ObjectOrder> childList = new ArrayList<ObjectOrder>();

    @Override
    public void draw(Graphics2D g2) {
        for (ObjectOrder objectOrder : childList){

        }

    }

    @Override
    public void update() {

    }

    @Override
    public void addChild(GameObject o, int position) {
        ObjectOrder objectOrder = new ObjectOrder(position, o);
        childList.add(objectOrder);

        Collections.sort(childList, new Comparator<ObjectOrder>(){
            public int compare(ObjectOrder o1, ObjectOrder o2){
                if(o1.order == o2.order)
                    return 0;
                return o1.order < o2.order ? -1 : 1;
            }
        });
    }
}
