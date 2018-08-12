package model.shapes.shapedata;


import model.shapes.enums.ShapeColor;
import java.awt.Color;
import java.util.EnumMap;

public final class ColorAdaptor {

    /*Maps ShapeColor enum to java.awt.Color*/
    private final EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
    /*Create single instance of color adaptor*/
    private static ColorAdaptor instance = new ColorAdaptor();
    /*private constructor-singleton pattern. Fills EnumMap*/
    private ColorAdaptor() {
        colorMap.put(ShapeColor.BLACK, Color.BLACK);
        colorMap.put(ShapeColor.BLUE, Color.BLUE);
        colorMap.put(ShapeColor.CYAN, Color.CYAN);
        colorMap.put(ShapeColor.DARK_GRAY, Color.DARK_GRAY);
        colorMap.put(ShapeColor.GRAY, Color.GRAY);
        colorMap.put(ShapeColor.GREEN, Color.GREEN);
        colorMap.put(ShapeColor.LIGHT_GRAY, Color.LIGHT_GRAY);
        colorMap.put(ShapeColor.MAGENTA, Color.MAGENTA);
        colorMap.put(ShapeColor.ORANGE, Color.ORANGE);
        colorMap.put(ShapeColor.PINK, Color.PINK);
        colorMap.put(ShapeColor.RED, Color.RED);
        colorMap.put(ShapeColor.WHITE, Color.WHITE);
        colorMap.put(ShapeColor.YELLOW, Color.YELLOW);
    }
    /*Takes an enum color and returns the corresponding java.awt.Color*/
    public static Color adaptColor(ShapeColor enumColor) {
        return instance.colorMap.get(enumColor);
    }

}