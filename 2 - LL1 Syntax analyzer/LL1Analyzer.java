import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.Stack;

public class LL1Analyzer {
	static final int POP = -2;
	static final int E = -1;
	
	private static final int[][] syntaxTable = {
		//	   case   (   ID    )    {   when  }    =  CONST  :    ;    #
		/* 0*/ {POP,   E,   E,   E,   E,   E,   E,   E,   E,   E,   E,   E}, // case
		/* 1*/ {  E, POP,   E,   E,   E,   E,   E,   E,   E,   E,   E,   E}, // (
		/* 2*/ {  E,   E, POP,   E,   E,   E,   E,   E,   E,   E,   E,   E}, // ID
		/* 3*/ {  E,   E,   E, POP,   E,   E,   E,   E,   E,   E,   E,   E}, // )
		/* 4*/ {  E,   E,   E,   E, POP,   E,   E,   E,   E,   E,   E,   E}, // {
		/* 5*/ {  E,   E,   E,   E,   E, POP,   E,   E,   E,   E,   E,   E}, // when
		/* 6*/ {  E,   E,   E,   E,   E,   E, POP,   E,   E,   E,   E,   E}, // }
		/* 7*/ {  E,   E,   E,   E,   E,   E,   E, POP,   E,   E,   E,   E}, // =
		/* 8*/ {  E,   E,   E,   E,   E,   E,   E,   E, POP,   E,   E,   E}, // CONST
		/* 9*/ {  E,   E,   E,   E,   E,   E,   E,   E,   E, POP,   E,   E}, // :
		/*10*/ {  E,   E,   E,   E,   E,   E,   E,   E,   E,   E, POP,   E}, // ;
		/*11*/ {  E,   E,   E,   E,   E,   E,   E,   E,   E,   E,   E,   0}, // #
		/*12*/ {  1,   E,   E,   E,   E,   E,   E,   E,   E,   E,   E,   E}, // CaseStatement
		/*13*/ {  E,   E,   E,   E,   E,   2,   E,   E,   E,   E,   E,   E}, // WhenStatementList
		/*14*/ {  E,   E,   E,   E,   E,   5,   E,   E,   E,   E,   E,   E}, // WhenStatement
		/*15*/ {  E,   E,   E,   E,   E,   3,   4,   E,   E,   E,   E,   E}, // WhenStatementList'
		/*16*/ {  6,   E,   7,   E,   E,   E,   E,   E,   E,   E,   E,   E}, // Statement
		/*17*/ {  E,   E,   8,   E,   E,   E,   E,   E,   9,   E,   E,   E}, // Statement'
		//       0    1    2    3	 4	  5	   6    7    8    9    10   11
	};

	private static final int[][] productionRules = {
			// 1) CaseStatement -> case ( ID ) { WhenStatementList }
			{ sym.CASE, sym.LEFTPAR, sym.ID, sym.RIGHTPAR, sym.LEFTBRACKET, NTSym.WhenStatementList, sym.RIGHTBRACKET },

			// 2) WhenStatementList -> WhenStatement WhenStatementList'
			{ NTSym.WhenStatement, NTSym.WhenStatementListP },

			// 3) WhenStatementList' -> WhenStatement WhenStatementList’
			{ NTSym.WhenStatement, NTSym.WhenStatementListP },

			// 4) WhenStatementList' -> ε
			{},

			// 5) WhenStatement -> when CONST : Statement
			{ sym.WHEN, sym.CONST, sym.COLON, NTSym.Statement },

			// 6) Statement -> CaseStatement
			{ NTSym.CaseStatement },

			// 7) Statement -> ID = Statement’
			{ sym.ID, sym.ASSIGN, NTSym.StatementP },

			// 8) Statement’ -> ID ;
			{ sym.ID, sym.SEMICOLON },

			// 9) Statement’ -> CONST ;
			{ sym.CONST, sym.SEMICOLON }
	};

	public static void main(String[] argv) throws IOException {
		FileInputStream stream = new java.io.FileInputStream("testinput.txt");
		Reader reader = new java.io.InputStreamReader(stream);

		AnalyzeLL1(new MPLexer(reader));
	}

	private static void AnalyzeLL1(MPLexer lexer) throws IOException {
		Stack<Integer> stack = new Stack<>();
		stack.push(sym.EOF);
		stack.push(NTSym.CaseStatement);

		boolean accepted = false;
		boolean error = false;

		int nextSymbol = lexer.next_token().m_index;
		System.out.println("Current token: " + nextSymbol);
		do {
			int row = stack.peek();
			int col = nextSymbol;
			switch (syntaxTable[row][col]) {
				case POP:
					stack.pop();
					nextSymbol = lexer.next_token().m_index;
					System.out.println("Action: POP");
					break;
				case E:
					error = true;
					System.out.println("Action: ERROR");
					break;
				case 0:
					accepted = true;
					System.out.println("Action: ACCEPTED");
					break;
				default:
					int rule = syntaxTable[row][col];
					stack.pop();
					for (int i = productionRules[rule - 1].length - 1; i >= 0; i--) {
						stack.push(productionRules[rule - 1][i]);
					}
					System.out.println("Action: Smena - " + rule);
					break;
			}
		} while (!(accepted || error));
	}
}
