// import section
import java_cup.runtime.*;

%%
// declaration section
%class IzrazLexer

%cup

%line
%column

%eofval{
	return new Symbol( sym.EOF );
%eofval}


//states
%state COMMENT
//macros
slovo = [a-zA-Z]
cifra = [0-9]

%%
// rules section

[\t\r\n ]		{ ; }

//operators
\+				{ return new Symbol( sym.PLUS ); }
\*				{ return new Symbol( sym.PUTA );  }


{cifra}+		{ return new Symbol( sym.CONST, Integer.parseInt(yytext()) ); }


//error symbol
.		{ System.out.println( "ERROR: " + yytext() ); }

