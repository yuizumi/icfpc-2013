package piyopiyo.py.expressions;

public class Plus extends BinaryExpression {
    public static BinaryExpressionFactory FACTORY =
        new BinaryExpressionFactory() {
            @Override
            public BinaryExpression create(Expression e0, Expression e1) {
                return new Plus(e0, e1);
            }
        };

    public Plus(Expression e0, Expression e1) {
        super(e0, e1);
    }

    @Override
    public long eval() { return e0.eval() + e1.eval(); }

    @Override
    public BinaryExpressionFactory factory() { return FACTORY; }

    @Override
    public String name() { return "plus"; }

    @Override
    public boolean isRedundant() {
        return e0 == Constant.ZERO || e1 == Constant.ZERO || e0 == e1;
    }
}
