package AST;

import java.io.BufferedWriter;
import java.io.IOException;

public class WhenStatement extends Statement {

    private ConstantExpression constant;
    private Statement statement;

    public WhenStatement(ConstantExpression c, Statement s) {
        this.constant = c;
        this.statement = s;
    }

    public void translateStatement(BufferedWriter out) throws IOException {
        this.statement.translate(out);
    }

    @Override
    public void translate(BufferedWriter out) throws IOException {
        this.constant.translate(out);
        this.constant.genLoad("R2", out);
        out.write("\tCompare_Equal\tR1, R2");
        out.newLine();
    }
}
