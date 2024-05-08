package main.StaticImage;

import main.interfaces.Clickable;

import java.awt.event.MouseEvent;

public abstract class ImageButton extends StaticImage implements Clickable {
    public ImageButton(String imageString, int x, int y) {
        super(imageString, x, y);
    }
}
