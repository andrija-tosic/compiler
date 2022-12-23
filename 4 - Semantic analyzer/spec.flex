// import sekcija

import java_cup.runtime.*;

%%

// Sekcija opcija i deklaracija
%class MPLexer

%cup

%line
%column

%eofval{
  return new Symbol( sym.EOF );
%eofval}

%{
  public int level;

  public int getLine() 
  {
    return yyline;
  }

  public int getLevel() {
    return level;
  }

  public void incrementLevel() {
    level++;
  }

  public void decrementLevel() {
    level--;
  }
%}

%init{
  level = 0;
%init}

// Stanja
%xstate KOMENTAR

// Makroi
slovo = [a-zA-Z]
cifra = [0-9]

%%

// Pravila
%% { yybegin( KOMENTAR ); }
<KOMENTAR>~"%%" { yybegin(YYINITIAL); }

[\t\n\r ] { ; }

// Operatori

\+ { System.out.println("Plus");  return new Symbol(sym.PLUS);  }
\- { System.out.println("Minus"); return new Symbol(sym.MINUS); }

// Separatori
;  { System.out.println("Separator ;"); return new Symbol(sym.SEMICOLON);    }
:  { System.out.println("Separator :"); return new Symbol(sym.COLON);        }
,  { System.out.println("Separator ,"); return new Symbol(sym.COMMA);        }
=  { System.out.println("Separator ="); return new Symbol(sym.ASSIGN);       }
\( { System.out.println("Separator ("); return new Symbol(sym.LEFTPAR);      }
\) { System.out.println("Separator )"); return new Symbol(sym.RIGHTPAR);     }
\{ { System.out.println("Separator {"); return new Symbol(sym.LEFTBRACKET);  }
\} { System.out.println("Separator }"); return new Symbol(sym.RIGHTBRACKET); }

// Kljucne reci
"main"  { System.out.println("main");  return new Symbol(sym.MAIN);  }
"int"   { System.out.println("int");   return new Symbol(sym.INT);   }
"char"  { System.out.println("char");  return new Symbol(sym.CHAR);  }
"float" { System.out.println("float"); return new Symbol(sym.FLOAT); }
"case"  { System.out.println("case");  return new Symbol(sym.CASE);  }
"when"  { System.out.println("when");  return new Symbol(sym.WHEN);  }


// Identifikatori
({slovo}|_)({slovo}|{cifra}|_)* { System.out.println(yytext()); return new Symbol(sym.ID, yytext()); }

// Konstante

// int

// oct
0oct[0-7]+ { System.out.println(yytext());    return new Symbol( sym.INTCONST, Integer.parseInt(yytext().substring(4), 8)); }

// hex
0hex[0-9A-F]+ { System.out.println(yytext()); return new Symbol( sym.INTCONST, Integer.parseInt(yytext().substring(4), 16)); }

// dec
0dec[0-9]+ { System.out.println(yytext()); return new Symbol( sym.INTCONST, Integer.parseInt(yytext().substring(4))); }
[0-9]+ { System.out.println(yytext()); return new Symbol( sym.INTCONST, Integer.parseInt(yytext())); }

// float
[0-9]+\.[0-9]*(E(\+|-)?[0-9]+)? { System.out.println(yytext()); return new Symbol( sym.FLOATCONST, Float.parseFloat(yytext())); }

// char
'[^]' {System.out.println(yytext()); return new Symbol( sym.CHARCONST, yytext().charAt(1) ); }

// Obrada gresaka
. { if (yytext() != null && yytext().length() > 0) System.out.println( "ERROR: " + yytext() ); }
