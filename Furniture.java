// Element interface that all furniture classes will implement
public interface Furniture {
    double accept(ShippingCostVisitor visitor);
    String getName();
    String getDescription();
}