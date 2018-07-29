package model.shapes.shapeData;

import model.shapes.shapeEnums.ShapeColor;

import java.awt.*;

public class ColorAdaptor {

    public static Color ChangeColor(ShapeObject shape, char primaryOrSecondary) {
        ShapeColor shapeColor;
        if(primaryOrSecondary == 'p')
            shapeColor = shape.getShapePrimaryColor();
        else
            shapeColor = shape.getShapeSecondaryColor();

        switch (shapeColor) {
            case BLACK:
                return Color.BLACK;
            case BLUE:
                return Color.BLUE;
            case CYAN:
                return Color.CYAN;
            case DARK_GRAY:
                return Color.DARK_GRAY;
            case GRAY:
                return Color.GRAY;
            case GREEN:
                return Color.GREEN;
            case LIGHT_GRAY:
                return Color.LIGHT_GRAY;
            case MAGENTA:
                return Color.MAGENTA;
            case ORANGE:
                return Color.ORANGE;
            case PINK:
                return Color.PINK;
            case RED:
                return Color.RED;
            case WHITE:
                return Color.WHITE;
            case YELLOW:
                return Color.YELLOW;
        }
        return Color.BLUE;
    }

}
