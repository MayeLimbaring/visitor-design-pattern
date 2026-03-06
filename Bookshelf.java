public class Bookshelf implements Furniture {
    private String name;
    private double height;
    private int numberOfShelves;
    private boolean isAssembled;
    
    public Bookshelf(String name, double height, int numberOfShelves, boolean isAssembled) {
        this.name = name;
        this.height = height;
        this.numberOfShelves = numberOfShelves;
        this.isAssembled = isAssembled;
    }
    
    @Override
    public double accept(ShippingCostVisitor visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getDescription() {
        return String.format("Bookshelf: %s (Height: %.1f cm, Shelves: %d, Assembled: %s)", 
                            name, height, numberOfShelves, isAssembled ? "Yes" : "No");
    }
    
    // Getters specific to Bookshelf
    public double getHeight() {
        return height;
    }
    
    public int getNumberOfShelves() {
        return numberOfShelves;
    }
    
    public boolean isAssembled() {
        return isAssembled;
    }
}