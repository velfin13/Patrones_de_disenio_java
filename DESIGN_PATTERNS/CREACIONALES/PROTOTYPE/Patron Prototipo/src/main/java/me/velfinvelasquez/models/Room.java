package me.velfinvelasquez.models;

public class Room implements Cloneable {
    private String furniture;
    private String decoration;
    private String colorScheme;

    public Room(String furniture, String decoration, String colorScheme) {
        this.furniture = furniture;
        this.decoration = decoration;
        this.colorScheme = colorScheme;
    }

    // Getters y Setters
    public String getFurniture() {
        return furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public String getColorScheme() {
        return colorScheme;
    }

    public void setColorScheme(String colorScheme) {
        this.colorScheme = colorScheme;
    }

    @Override
    public Room clone() {
        try {
            return (Room) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "furniture='" + furniture + '\'' +
                ", decoration='" + decoration + '\'' +
                ", colorScheme='" + colorScheme + '\'' +
                '}';
    }
}
