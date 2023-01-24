package AST;

import java.io.BufferedWriter;
import java.io.IOException;

public class ConditionalExpression extends Expression {

    Expression expr1, expr2, expr3, expr4;

    public ConditionalExpression(Expression expr1, Expression expr2, Expression expr3, Expression expr4) {
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.expr3 = expr3;
        this.expr4 = expr4;
    }

    @Override
    public void translate(BufferedWriter out) throws IOException {
        String expr1Lab = genLab();
        String expr2Lab = genLab();
        String expr3Lab = genLab();
        String expr4Lab = genLab();
        String krajLab = genLab();
        
        this.expr1.translate(out);
        this.expr1.genLoad("R1", out);

        out.write("Load_Const R2, 0\n");

        out.write("Compare_Less R1, R2\n");
        out.write("JumpIfNotZero R1, " + expr1Lab + "\n");

        this.expr2.translate(out);
        this.expr2.genLoad("R1", out);
        
        out.write("Compare_Equal R1, R2\n");
        out.write("JumpIfNotZero R1, " + expr2Lab + "\n");

        this.expr3.translate(out);
        this.expr3.genLoad("R1", out);
        
        out.write("Compare_Equal R1, R2\n");
        out.write("JumpIfNotZero R1, " + expr3Lab + "\n");
        
        this.expr4.translate(out);
        this.expr4.genLoad("R1", out);
        
        out.write("Compare_Equal R1, R2\n");
        out.write("JumpIfNotZero R1, " + expr4Lab + "\n");

        out.write(expr1Lab + ":\n");
        expr1.genLoad("R1", out);
        out.write("Jump " + krajLab + "\n");

        out.write(expr2Lab + ":\n");
        expr1.genLoad("R1", out);
        out.write("Jump " + krajLab + "\n");

        out.write(expr3Lab + ":\n");
        expr1.genLoad("R1", out);
        out.write("Jump " + krajLab + "\n");

        out.write(expr4Lab + ":\n");
        expr1.genLoad("R1", out);
        out.write("Jump " + krajLab + "\n");

        out.write("kraj:\n");
    }
    
}
