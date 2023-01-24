package AST;



import java.io.*;

import SymbolTable.Constant;

public class ConstantExpression extends Expression {
	private Constant targetConst;
	
	public ConstantExpression( Constant c )
	{
		targetConst = c;
	}
	
	public void translate( BufferedWriter out )
	throws IOException
	{
		if (targetConst.type.name.compareTo("char") == 0) {
			this.result = "'" + targetConst.value.toString() + "'";
		}
		else {
			this.result = targetConst.value.toString();
		}
	}
	
	protected void genLoad( String reg, BufferedWriter out )
	throws IOException
	{
		out.write( "\tLoad_Const\t" + 
				reg + ", " + result );
		out.newLine();
	}
}
