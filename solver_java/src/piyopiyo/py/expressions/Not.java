package piyopiyo.py.expressions;

public class Not extends UnaryExpression {
    public static UnaryExpressionFactory FACTORY =
        new UnaryExpressionFactory() {
            @Override
            public UnaryExpression create(Expression e) { return new Not(e); }
        };

    public Not(Expression e) {
        super(e);
    }

    @Override
    public long eval() { return ~e.eval(); }

    @Override
    public UnaryExpressionFactory factory() { return FACTORY; }

    @Override
    public String name() { return "not"; }

    @Override
    public boolean isRedundant() {
        return e instanceof Not;
    }
}
