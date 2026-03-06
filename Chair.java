public class Chair implements Furniture {
    private String name;
    private double weight;
    private boolean isStackable;
    
    public Chair(String name, double weight, boolean isStackable) {
        this.name = name;
        this.weight = weight;
        this.isStackable = isStackable;
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
        return String.format("Chair: %s (Weight: %.1f kg, Stackable: %s)", 
                            name, weight, isStackable ? "Yes" : "No");
    }
    
    // Getters specific to Chair
    public double getWeight() {
        return weight;
    }
    
    public boolean isStackable() {
        return isStackable;
    }
}