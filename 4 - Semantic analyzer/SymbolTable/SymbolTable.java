package SymbolTable;

import java_cup.runtime.Symbol;

public class SymbolTable {
	
	/*tabela simbola za "language scope"
	u ovom slucaju tu pripadaju samo tipovi*/
	private SymbolNode types;
	
	/* tabela simbola za oblast vazenja programa */
	private SymbolNode variables;
	
	public SymbolTable( )
	{
		types = new Type( "unknown", Type.UNKNOWN, null);
		types = new Type( "char", Type.CHAR, types );
		types = new Type( "int", Type.INT, types );
		types = new Type( "float", Type.FLOAT, types );
		variables = null;
	}

	public void removeVarsByLevel(int level) {
		SymbolNode temp = variables;
		SymbolNode prev = null;
		
        while (temp != null && temp.kind == SymbolNode.VARIABLE && ((Variable)temp).level == level) 
        {
            variables = temp.next;
            temp = variables;
        }
  
        while (temp != null) 
        {
            while (temp != null && temp.kind == SymbolNode.VARIABLE && ((Variable)temp).level != level) 
            {
                prev = temp;
                temp = temp.next;
            }
  
            if (temp == null)
                return;
  
            prev.next = temp.next;
  
            temp = prev.next;
        }
	}

	public boolean addVar(String name, int level, Type type)
	{
		Variable existing = this.getVar( name );
		if (existing != null && existing.level <= level)
			return false;
		variables = new Variable( name, type, level, variables );
		return true;
	}
	
	public Variable getVar( String name )
	{
		SymbolNode current = variables;
		while ( current != null && 
				current.name.compareTo( name ) != 0 )
			current = current.next;
		return ( Variable ) current;
	}
	
	public Type getType(String typeName)
	{
		SymbolNode current = types;
		while ( current != null && 
				current.name.compareTo( typeName ) != 0 )
			current = current.next;
		return ( Type ) current;
	}
	
	public SymbolNode getVariables()
	{
		return variables;
	}

}
