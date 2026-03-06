public class Table implements Furniture {
    private String name;
    private double length;
    private double width;
    private double height;
    private boolean requiresDisassembly;
    
    public Table(String name, double length, double width, double height, boolean requiresDisassembly) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.requiresDisassembly = requiresDisassembly;
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
        return String.format("Table: %s (Dimensions: %.1f x %.1f x %.1f cm, Disassembly: %s)", 
                            name, length, width, height, requiresDisassembly ? "Required" : "Not Required");
    }
    
    // Getters specific to Table
    public double getVolume() {
        return length * width * height;
    }
    
    public boolean isRequiresDisassembly() {
        return requiresDisassembly;
    }
}