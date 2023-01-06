package AST;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CaseStatement extends Statement {

    private Expression expr;
    private ArrayList<WhenStatement> whenStatements;

    public CaseStatement(Expression e, ArrayList<WhenStatement> niz) {
        this.expr = e;
        this.whenStatements = niz;
    }

    @Override
    public void translate(BufferedWriter out) throws IOException {
        expr.translate(out);
        expr.genLoad("R1", out);
        
        for (int i=0; i<this.whenStatements.size(); i++){
            this.whenStatements.get(i).translate(out);

            out.write("\tJumpIfZero\tL" + i);
            out.newLine();
        }

        for (int i=0; i<this.whenStatements.size(); i++){
            out.write("L" + i + ":");
            out.newLine();

            this.whenStatements.get(i).translateStatement(out);
            out.write("\tJump L_END");
            out.newLine();
        }

        out.write("L_END:");
        out.newLine();
    }
    
}
