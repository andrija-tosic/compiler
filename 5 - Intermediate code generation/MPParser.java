
//----------------------------------------------------
// The following code was generated by CUP v0.10k
// Fri Jan 13 11:08:35 CET 2023
//----------------------------------------------------

import java_cup.runtime.*;
import java.io.*;
import java.util.*;
import SymbolTable.*;
import AST.*;

/** CUP v0.10k generated parser.
  * @version Fri Jan 13 11:08:35 CET 2023
  */
public class MPParser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public MPParser() {super();}

  /** Constructor which sets the default scanner. */
  public MPParser(java_cup.runtime.Scanner s) {super(s);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\036\000\002\002\004\000\002\003\006\000\002\004" +
    "\006\000\002\005\004\000\002\005\002\000\002\007\005" +
    "\000\002\020\003\000\002\020\005\000\002\015\003\000" +
    "\002\015\003\000\002\015\003\000\002\006\004\000\002" +
    "\006\003\000\002\010\003\000\002\010\006\000\002\010" +
    "\003\000\002\011\011\000\002\017\004\000\002\017\003" +
    "\000\002\016\006\000\002\013\005\000\002\013\003\000" +
    "\002\012\003\000\002\012\003\000\002\014\003\000\002" +
    "\014\003\000\002\014\005\000\002\021\003\000\002\021" +
    "\003\000\002\021\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\067\000\004\004\005\001\002\000\004\002\071\001" +
    "\002\000\004\005\006\001\002\000\004\006\007\001\002" +
    "\000\004\007\010\001\002\000\016\007\ufffd\012\ufffd\013" +
    "\ufffd\014\ufffd\015\ufffd\022\ufffd\001\002\000\004\002\000" +
    "\001\002\000\016\007\010\012\023\013\014\014\024\015" +
    "\025\022\021\001\002\000\004\022\064\001\002\000\004" +
    "\022\ufff9\001\002\000\014\007\ufff2\010\ufff2\012\ufff2\020" +
    "\ufff2\022\ufff2\001\002\000\012\007\010\010\062\012\023" +
    "\022\021\001\002\000\016\007\ufffe\012\ufffe\013\ufffe\014" +
    "\ufffe\015\ufffe\022\ufffe\001\002\000\012\007\ufff5\010\ufff5" +
    "\012\ufff5\022\ufff5\001\002\000\004\017\057\001\002\000" +
    "\014\007\ufff4\010\ufff4\012\ufff4\020\ufff4\022\ufff4\001\002" +
    "\000\004\005\026\001\002\000\004\022\ufff8\001\002\000" +
    "\004\022\ufff7\001\002\000\014\005\034\022\027\025\030" +
    "\026\035\027\036\001\002\000\012\006\uffe9\011\uffe9\023" +
    "\uffe9\024\uffe9\001\002\000\014\006\uffe6\011\uffe6\021\uffe6" +
    "\023\uffe6\024\uffe6\001\002\000\012\006\uffec\011\uffec\023" +
    "\uffec\024\uffec\001\002\000\010\006\045\023\042\024\043" +
    "\001\002\000\012\006\uffe8\011\uffe8\023\uffe8\024\uffe8\001" +
    "\002\000\014\005\034\022\027\025\030\026\035\027\036" +
    "\001\002\000\014\006\uffe5\011\uffe5\021\uffe5\023\uffe5\024" +
    "\uffe5\001\002\000\014\006\uffe4\011\uffe4\021\uffe4\023\uffe4" +
    "\024\uffe4\001\002\000\010\006\040\023\042\024\043\001" +
    "\002\000\012\006\uffe7\011\uffe7\023\uffe7\024\uffe7\001\002" +
    "\000\014\005\034\022\027\025\030\026\035\027\036\001" +
    "\002\000\014\005\uffeb\022\uffeb\025\uffeb\026\uffeb\027\uffeb" +
    "\001\002\000\014\005\uffea\022\uffea\025\uffea\026\uffea\027" +
    "\uffea\001\002\000\012\006\uffed\011\uffed\023\uffed\024\uffed" +
    "\001\002\000\004\007\046\001\002\000\004\020\051\001" +
    "\002\000\006\010\uffef\020\uffef\001\002\000\006\010\055" +
    "\020\051\001\002\000\010\025\030\026\035\027\036\001" +
    "\002\000\004\021\053\001\002\000\010\007\010\012\023" +
    "\022\021\001\002\000\006\010\uffee\020\uffee\001\002\000" +
    "\014\007\ufff1\010\ufff1\012\ufff1\020\ufff1\022\ufff1\001\002" +
    "\000\006\010\ufff0\020\ufff0\001\002\000\014\005\034\022" +
    "\027\025\030\026\035\027\036\001\002\000\010\011\061" +
    "\023\042\024\043\001\002\000\014\007\ufff3\010\ufff3\012" +
    "\ufff3\020\ufff3\022\ufff3\001\002\000\016\002\uffff\007\uffff" +
    "\010\uffff\012\uffff\020\uffff\022\uffff\001\002\000\012\007" +
    "\ufff6\010\ufff6\012\ufff6\022\ufff6\001\002\000\006\011\ufffb" +
    "\016\ufffb\001\002\000\006\011\067\016\066\001\002\000" +
    "\004\022\070\001\002\000\016\007\ufffc\012\ufffc\013\ufffc" +
    "\014\ufffc\015\ufffc\022\ufffc\001\002\000\006\011\ufffa\016" +
    "\ufffa\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\067\000\004\003\003\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\004\010\001\001" +
    "\000\004\005\011\001\001\000\002\001\001\000\016\004" +
    "\014\006\015\007\016\010\017\011\021\015\012\001\001" +
    "\000\004\020\064\001\001\000\002\001\001\000\002\001" +
    "\001\000\010\004\014\010\062\011\021\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\010\013\031\014\030\021\032\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\012\040" +
    "\001\001\000\002\001\001\000\010\013\036\014\030\021" +
    "\032\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\012\040\001\001\000\002\001\001\000\006\014\043\021" +
    "\032\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\006\016\046\017\047\001" +
    "\001\000\002\001\001\000\004\016\055\001\001\000\004" +
    "\021\051\001\001\000\002\001\001\000\010\004\014\010" +
    "\053\011\021\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\010\013\057\014\030\021\032\001" +
    "\001\000\004\012\040\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$MPParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$MPParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$MPParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {

 symbolTable = new SymbolTable();

    }


 SymbolTable symbolTable;

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$MPParser$actions {
  private final MPParser parser;

  /** Constructor */
  CUP$MPParser$actions(MPParser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$MPParser$do_action(
    int                        CUP$MPParser$act_num,
    java_cup.runtime.lr_parser CUP$MPParser$parser,
    java.util.Stack            CUP$MPParser$stack,
    int                        CUP$MPParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$MPParser$result;

      /* select the action based on the action number */
      switch (CUP$MPParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // Constant ::= FLOATCONST 
            {
              Constant RESULT = null;
		int cleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		Float c = (Float)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
      RESULT = new Constant(parser.symbolTable.getType("float"), c ); 
   
              CUP$MPParser$result = new java_cup.runtime.Symbol(15/*Constant*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // Constant ::= CHARCONST 
            {
              Constant RESULT = null;
		int cleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		Character c = (Character)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
      RESULT = new Constant(parser.symbolTable.getType("char"), c ); 
   
              CUP$MPParser$result = new java_cup.runtime.Symbol(15/*Constant*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // Constant ::= INTCONST 
            {
              Constant RESULT = null;
		int cleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		Integer c = (Integer)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
      RESULT = new Constant(parser.symbolTable.getType("int"), c ); 
   
              CUP$MPParser$result = new java_cup.runtime.Symbol(15/*Constant*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // Term ::= LEFTPAR Expression RIGHTPAR 
            {
              Expression RESULT = null;
		int ileft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).right;
		Expression i = (Expression)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).value;
		
      RESULT = i;
   
              CUP$MPParser$result = new java_cup.runtime.Symbol(10/*Term*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-2)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // Term ::= Constant 
            {
              Expression RESULT = null;
		int kleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int kright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		Constant k = (Constant)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
      RESULT = new ConstantExpression(k);
   
              CUP$MPParser$result = new java_cup.runtime.Symbol(10/*Term*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // Term ::= ID 
            {
              Expression RESULT = null;
		int imeleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int imeright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		String ime = (String)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
      Variable var = parser.symbolTable.getVar( ime );
      RESULT = new VariableExpression(var);
   
              CUP$MPParser$result = new java_cup.runtime.Symbol(10/*Term*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // AddOperator ::= MINUS 
            {
              Symbol RESULT = null;
		int opleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		Object op = (Object)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
      RESULT = new Symbol(sym.MINUS);
   
              CUP$MPParser$result = new java_cup.runtime.Symbol(8/*AddOperator*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // AddOperator ::= PLUS 
            {
              Symbol RESULT = null;
		int opleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		Object op = (Object)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
      RESULT = new Symbol(sym.PLUS);
   
              CUP$MPParser$result = new java_cup.runtime.Symbol(8/*AddOperator*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // Expression ::= Term 
            {
              Expression RESULT = null;
		int tleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		Expression t = (Expression)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
      RESULT = t;
   
              CUP$MPParser$result = new java_cup.runtime.Symbol(9/*Expression*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // Expression ::= Expression AddOperator Term 
            {
              Expression RESULT = null;
		int i1left = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-2)).left;
		int i1right = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-2)).right;
		Expression i1 = (Expression)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-2)).value;
		int opleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).right;
		Symbol op = (Symbol)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).value;
		int i2left = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int i2right = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		Expression i2 = (Expression)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
      if (op.sym == sym.PLUS){
         RESULT = new Sum(i1, i2);
      }
      else {
         RESULT = new Difference(i1, i2);
      }
   
              CUP$MPParser$result = new java_cup.runtime.Symbol(9/*Expression*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-2)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // WhenStatement ::= WHEN Constant COLON Statement 
            {
              Statement RESULT = null;
		int cleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-2)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-2)).right;
		Constant c = (Constant)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-2)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		Statement s = (Statement)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
      RESULT = new WhenStatement(new ConstantExpression(c), s);
   
              CUP$MPParser$result = new java_cup.runtime.Symbol(12/*WhenStatement*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-3)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // WhenStatementList ::= WhenStatement 
            {
              ArrayList RESULT = null;
		int wsleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int wsright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		Statement ws = (Statement)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
      RESULT = new ArrayList();
      RESULT.add(ws);
   
              CUP$MPParser$result = new java_cup.runtime.Symbol(13/*WhenStatementList*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // WhenStatementList ::= WhenStatementList WhenStatement 
            {
              ArrayList RESULT = null;
		int nizleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).left;
		int nizright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).right;
		ArrayList niz = (ArrayList)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).value;
		int wsleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int wsright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		Statement ws = (Statement)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
      RESULT = niz;
      niz.add(ws);
   
              CUP$MPParser$result = new java_cup.runtime.Symbol(13/*WhenStatementList*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // CaseStatement ::= CASE LEFTPAR Expression RIGHTPAR LEFTBRACKET WhenStatementList RIGHTBRACKET 
            {
              Statement RESULT = null;
		int exprleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-4)).left;
		int exprright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-4)).right;
		Expression expr = (Expression)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-4)).value;
		int nizleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).left;
		int nizright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).right;
		ArrayList niz = (ArrayList)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).value;
		
      RESULT = new CaseStatement(expr, niz);
   
              CUP$MPParser$result = new java_cup.runtime.Symbol(7/*CaseStatement*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-6)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // Statement ::= Block 
            {
              Statement RESULT = null;
		int bleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		Block b = (Block)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
         RESULT = b;
      
              CUP$MPParser$result = new java_cup.runtime.Symbol(6/*Statement*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // Statement ::= ID ASSIGN Expression SEMICOLON 
            {
              Statement RESULT = null;
		int idleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-3)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-3)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-3)).value;
		int exprleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).left;
		int exprright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).right;
		Expression expr = (Expression)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).value;
		
         Variable var = parser.symbolTable.getVar(id);

         RESULT = new Assignment(var, expr);
      
              CUP$MPParser$result = new java_cup.runtime.Symbol(6/*Statement*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-3)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // Statement ::= CaseStatement 
            {
              Statement RESULT = null;
		int csleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int csright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		Statement cs = (Statement)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
         RESULT = cs;
      
              CUP$MPParser$result = new java_cup.runtime.Symbol(6/*Statement*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // StatementList ::= Statement 
            {
              Block RESULT = null;
		int nleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		Statement n = (Statement)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
         RESULT = new Block();
         RESULT.addStatement(n);
      
              CUP$MPParser$result = new java_cup.runtime.Symbol(4/*StatementList*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // StatementList ::= StatementList Statement 
            {
              Block RESULT = null;
		int nnleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).left;
		int nnright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).right;
		Block nn = (Block)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).value;
		int nleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		Statement n = (Statement)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
         RESULT = nn;
         RESULT.addStatement(n);
      
              CUP$MPParser$result = new java_cup.runtime.Symbol(4/*StatementList*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // Type ::= FLOAT 
            {
              Type RESULT = null;
		
         RESULT = parser.symbolTable.getType("float");
      
              CUP$MPParser$result = new java_cup.runtime.Symbol(11/*Type*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // Type ::= CHAR 
            {
              Type RESULT = null;
		
         RESULT = parser.symbolTable.getType("char");
      
              CUP$MPParser$result = new java_cup.runtime.Symbol(11/*Type*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // Type ::= INT 
            {
              Type RESULT = null;
		
         RESULT = parser.symbolTable.getType("int");
      
              CUP$MPParser$result = new java_cup.runtime.Symbol(11/*Type*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // NameList ::= NameList COMMA ID 
            {
              ArrayList RESULT = null;
		int nizleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-2)).left;
		int nizright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-2)).right;
		ArrayList niz = (ArrayList)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-2)).value;
		int imeleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int imeright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		String ime = (String)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
            RESULT = niz;
            RESULT.add(ime);
         
              CUP$MPParser$result = new java_cup.runtime.Symbol(14/*NameList*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-2)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // NameList ::= ID 
            {
              ArrayList RESULT = null;
		int imeleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int imeright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		String ime = (String)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
            RESULT = new ArrayList();
            RESULT.add(ime);
         
              CUP$MPParser$result = new java_cup.runtime.Symbol(14/*NameList*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // VarDecl ::= Type NameList SEMICOLON 
            {
              Object RESULT = null;
		int tleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-2)).right;
		Type t = (Type)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-2)).value;
		int nizleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).left;
		int nizright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).right;
		ArrayList niz = (ArrayList)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).value;
		
               for ( int i = 0; i < niz.size(); i++ ) {
                  String ime = (String) niz.get(i);
                  parser.symbolTable.addVar(ime, t);
               }
         
              CUP$MPParser$result = new java_cup.runtime.Symbol(5/*VarDecl*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-2)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // Declarations ::= 
            {
              Object RESULT = null;
		
         
              CUP$MPParser$result = new java_cup.runtime.Symbol(3/*Declarations*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // Declarations ::= Declarations VarDecl 
            {
              Object RESULT = null;
		
         
              CUP$MPParser$result = new java_cup.runtime.Symbol(3/*Declarations*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // Block ::= LEFTBRACKET Declarations StatementList RIGHTBRACKET 
            {
              Block RESULT = null;
		int nnleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).left;
		int nnright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).right;
		Block nn = (Block)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).value;
		
            RESULT = nn;
         
              CUP$MPParser$result = new java_cup.runtime.Symbol(2/*Block*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-3)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // Program ::= MAIN LEFTPAR RIGHTPAR Block 
            {
              Block RESULT = null;
		int bleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right;
		Block b = (Block)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).value;
		
            RESULT = b; 
         
              CUP$MPParser$result = new java_cup.runtime.Symbol(1/*Program*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-3)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          return CUP$MPParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= Program EOF 
            {
              Object RESULT = null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).right;
		Block start_val = (Block)((java_cup.runtime.Symbol) CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).value;
		RESULT = start_val;
              CUP$MPParser$result = new java_cup.runtime.Symbol(0/*$START*/, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$MPParser$stack.elementAt(CUP$MPParser$top-0)).right, RESULT);
            }
          /* ACCEPT */
          CUP$MPParser$parser.done_parsing();
          return CUP$MPParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

