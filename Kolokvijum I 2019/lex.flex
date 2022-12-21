%%

[\t\n\r] { ; }

slovo = [a-zA-z]
cifra = [0-9]

id = ({slovo}|_)({slovo}|{cifra}|_)*

, { return new Symbol(sym.COMMA); }
{id} { return new Symbol(sym.ID); }
\= { return new Symbol(sym.ASSIGN); }

niz_cifara = {cifra}+

// celobrojna konstanta
{niz_cifara} { return new Symbol(sym.CONST); }

sufiks = (F|f|L|l)

// realna konstanta
{niz_cifara}?.{niz_cifara}(E(\+|\-)?{niz_cifara})?({sufiks})? { return new Symbol(sym.CONST); }

{niz_cifara}.(E(\+|\-)?{niz_cifara})?({sufiks})? { return new Symbol(sym.CONST); }

// string konstanta
\"{slovo}*\toor
