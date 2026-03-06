// Concrete visitor implementing standard shipping cost calculation
public class StandardShippingVisitor implements ShippingCostVisitor {
    private static final double BASE_RATE_PER_KG = 2.5;
    private static final double BULKY_ITEM_MULTIPLIER = 1.5;
    private static final double FLAT_RATE_CHAIR = 15.0;
    private static final double FLAT_RATE_BOOKSHELF = 25.0;
    
    @Override
    public double visit(Chair chair) {
        // Chairs have a flat rate plus weight factor
        return FLAT_RATE_CHAIR + (chair.getWeight() * BASE_RATE_PER_KG);
    }
    
    @Override
    public double visit(Table table) {
        // Tables cost based on volume and disassembly requirement
        double baseCost = table.getVolume() * 0.1; // $0.10 per cubic cm
        if (table.isRequiresDisassembly()) {
            baseCost *= 1.2; // 20% extra for disassembly
        }
        return baseCost;
    }
    
    @Override
    public double visit(Sofa sofa) {
        // Sofas are bulky - cost based on volume and material
        double baseCost = sofa.getVolume() * 0.15; // $0.15 per cubic cm
        if (sofa.getMaterial().equalsIgnoreCase("Leather")) {
            baseCost *= 1.3; // 30% extra for leather
        }
        return baseCost * sofa.getSeatCount();
    }
    
    @Override
    public double visit(Bookshelf bookshelf) {
        // Bookshelves cost based on height and assembly status
        double baseCost = bookshelf.getHeight() * 2.0; // $2 per cm of height
        if (!bookshelf.isAssembled()) {
            baseCost *= 0.7; // 30% discount if not assembled
        }
        return baseCost + (bookshelf.getNumberOfShelves() * 5.0); // $5 per shelf
    }
}