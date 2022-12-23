package SymbolTable;

public class Variable extends SymbolNode {
	
	public int last_def;
	public int last_use;

	public int level;
	
	public Variable(String name,  Type type, int level, SymbolNode next) {
		super( name, SymbolNode.VARIABLE, type, next );
		last_def = -1;

		this.level = level;
	}
	
}
