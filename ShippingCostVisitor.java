// Visitor interface that declares visit methods for each furniture type
public interface ShippingCostVisitor {
    double visit(Chair chair);
    double visit(Table table);
    double visit(Sofa sofa);
    double visit(Bookshelf bookshelf);
}