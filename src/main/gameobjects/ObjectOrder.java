package main.gameobjects;

public class ObjectOrder {
    public int order;
    public GameObjectInterface item;

    public ObjectOrder(int order, GameObjectInterface item){
        this.order = order;
        this.item = item;
    }
}
