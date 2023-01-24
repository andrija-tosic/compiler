package AST;

import java.io.BufferedWriter;
import java.io.IOException;

public class ExitStatement extends Statement {

    Expression expr;    
    String endLabel;

    public ExitStatement(Expression expr) {
        this.expr = expr;
    }

    @Override
    public void translate(BufferedWriter out) throws IOException {
        this.expr.translate(out);

        this.expr.genLoad("R1", out);
        out.write("JumpIfNotZero R1, " + endLabel + "\n");
    }
}