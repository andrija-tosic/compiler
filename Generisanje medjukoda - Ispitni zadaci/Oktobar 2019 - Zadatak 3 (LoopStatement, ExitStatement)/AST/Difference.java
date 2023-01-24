package AST;

public class Difference extends BinaryExpression {
	
	public Difference( Expression left, Expression right )
	{
		super( left, right );
	}
	
	protected String opCode()
	{
		return "Sub";
	}
}
