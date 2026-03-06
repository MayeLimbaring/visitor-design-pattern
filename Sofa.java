public class Sofa implements Furniture {
    private String name;
    private double length;
    private double width;
    private double height;
    private int seatCount;
    private String material;
    
    public Sofa(String name, double length, double width, double height, int seatCount, String material) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.seatCount = seatCount;
        this.material = material;
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
        return String.format("Sofa: %s (Dimensions: %.1f x %.1f x %.1f cm, Seats: %d, Material: %s)", 
                            name, length, width, height, seatCount, material);
    }
    
    // Getters specific to Sofa
    public double getVolume() {
        return length * width * height;
    }
    
    public int getSeatCount() {
        return seatCount;
    }
    
    public String getMaterial() {
        return material;
    }
}