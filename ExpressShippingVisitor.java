// Concrete visitor implementing express shipping cost calculation
public class ExpressShippingVisitor implements ShippingCostVisitor {
    private static final double EXPRESS_MULTIPLIER = 2.5;
    private static final double PRIORITY_FLAT_RATE = 50.0;
    
    @Override
    public double visit(Chair chair) {
        // Express shipping for chairs
        return (15.0 + (chair.getWeight() * 3.0)) * EXPRESS_MULTIPLIER;
    }
    
    @Override
    public double visit(Table table) {
        // Express shipping for tables
        double baseCost = table.getVolume() * 0.2; // Higher rate for express
        if (table.isRequiresDisassembly()) {
            baseCost *= 1.3;
        }
        return baseCost;
    }
    
    @Override
    public double visit(Sofa sofa) {
        // Express shipping for sofas - premium service
        double baseCost = sofa.getVolume() * 0.25;
        if (sofa.getMaterial().equalsIgnoreCase("Leather")) {
            baseCost *= 1.5;
        }
        return baseCost * sofa.getSeatCount() + PRIORITY_FLAT_RATE;
    }
    
    @Override
    public double visit(Bookshelf bookshelf) {
        // Express shipping for bookshelves
        double baseCost = bookshelf.getHeight() * 3.5;
        if (!bookshelf.isAssembled()) {
            baseCost *= 0.8;
        }
        return baseCost + (bookshelf.getNumberOfShelves() * 8.0) + 20.0;
    }
}