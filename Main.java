import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Furniture Shipping Cost Calculator ===\n");
        
        // Create different furniture items
        List<Furniture> furnitureList = new ArrayList<>();
        
        furnitureList.add(new Chair("Office Chair", 15.5, true));
        furnitureList.add(new Chair("Dining Chair", 8.2, true));
        furnitureList.add(new Table("Dining Table", 180, 90, 75, true));
        furnitureList.add(new Table("Coffee Table", 120, 60, 45, false));
        furnitureList.add(new Sofa("Sectional Sofa", 250, 90, 85, 4, "Fabric"));
        furnitureList.add(new Sofa("Leather Sofa", 200, 85, 80, 3, "Leather"));
        furnitureList.add(new Bookshelf("Tall Bookshelf", 210, 6, false));
        furnitureList.add(new Bookshelf("Small Bookshelf", 120, 3, true));
        
        // Create visitors for different shipping methods
        ShippingCostVisitor standardVisitor = new StandardShippingVisitor();
        ShippingCostVisitor expressVisitor = new ExpressShippingVisitor();
        
        // Calculate and display shipping costs
        System.out.println("FURNITURE DETAILS:");
        System.out.println("==================");
        
        for (Furniture furniture : furnitureList) {
            System.out.println("\n" + furniture.getDescription());
            
            // Calculate costs using both visitors
            double standardCost = furniture.accept(standardVisitor);
            double expressCost = furniture.accept(expressVisitor);
            
            System.out.printf("  Standard Shipping: $%.2f%n", standardCost);
            System.out.printf("  Express Shipping: $%.2f%n", expressCost);
            System.out.printf("  Express Premium: $%.2f extra%n", (expressCost - standardCost));
        }
        
        // Calculate total order cost
        System.out.println("\n=== ORDER SUMMARY ===");
        double totalStandard = 0;
        double totalExpress = 0;
        
        for (Furniture furniture : furnitureList) {
            totalStandard += furniture.accept(standardVisitor);
            totalExpress += furniture.accept(expressVisitor);
        }
        
        System.out.printf("Total Standard Shipping Cost: $%.2f%n", totalStandard);
        System.out.printf("Total Express Shipping Cost: $%.2f%n", totalExpress);
        System.out.printf("Savings with Standard Shipping: $%.2f%n", (totalExpress - totalStandard));
    }
}