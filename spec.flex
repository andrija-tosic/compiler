// import sekcija

%%

// Sekcija opcija i deklaracija
%class MPLexer
%function next_token
%type Yytoken
%line
%column
%debug



%eofval{
return new Yytoken( sym.EOF, null, yyline, yycolumn);
%eofval}

%{

// Dodatni clanovi generisane klase
KWTable kwTable = new KWTable();
Yytoken getKW()
{
	return new Yytoken( kwTable.find( yytext() ), yytext(), yyline, yycolumn );
}
%}

// Stanja
%xstate KOMENTAR

// Makroi
slovo = [a-zA-Z]
cifra = [0-9]

%%

// Pravila
%% { yybegin( KOMENTAR ); }
<KOMENTAR>~"%%" { yybegin( YYINITIAL ); }

[\t\n\r ] { ; }
\( { return new Yytoken( sym.LEFTPAR, yytext(), yyline, yycolumn ); }
\) { return new Yytoken( sym.RIGHTPAR, yytext(), yyline, yycolumn ); }

// Operatori

\+ { return new Yytoken( sym.PLUS, yytext(), yyline, yycolumn ); }
\- { return new Yytoken( sym.MINUS, yytext(), yyline, yycolumn ); }

// Separatori
; { return new Yytoken( sym.SEMICOLON, yytext(), yyline, yycolumn ); }
: { return new Yytoken( sym.COLON, yytext(), yyline, yycolumn ); }
, { return new Yytoken( sym.COMMA, yytext(), yyline, yycolumn ); }
= { return new Yytoken( sym.ASSIGN, yytext(), yyline, yycolumn ); }
\{ { return new Yytoken( sym.LEFTBRACKET, yytext(), yyline, yycolumn ); }
\} { return new Yytoken( sym.RIGHTBRACKET, yytext(), yyline, yycolumn ); }

// Kljucne reci
{slovo}+ { return getKW(); }

// Identifikatori
({slovo}|_)({slovo}|{cifra}|_)* { return new Yytoken(sym.ID, yytext(),yyline, yycolumn ); }

// Konstante

// int

// oct
0oct[0-7]+ { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }

// hex
0hex[0-9A-F]+ { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }

// dec
(0dec)?[0-9]+ { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }

// float
[0-9]+\.[0-9]*(E(\+|-)?[0-9]+)? { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }

// char
'[^]' { return new Yytoken( sym.CONST,yytext(), yyline, yycolumn ); }

// Obrada gresaka
. { if (yytext() != null && yytext().length() > 0) System.out.println( "ERROR: " + yytext() ); }
