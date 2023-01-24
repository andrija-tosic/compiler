package AST;
import java.io.BufferedWriter;
import java.io.IOException;

public class ForStatement extends Statement {
    Expression from;
    Expression to;
    Statement statement;

    @Override
    public void translate(BufferedWriter out) throws IOException {
        String petlja = ASTNode.genLab();
        String kraj = ASTNode.genLab();

        this.from.translate(out);
        this.from.genLoad("R1", out);

        this.to.translate(out);

        this.to.genLoad("R4", out);

        out.write(petlja + ":\n");
        out.write("Load_Const R2, 0\n");
        out.write("Add R2, R1\n");

        out.write("Compare_Less R2, R4\n");
        out.write("JumpIfZero \n" + kraj);

        this.statement.translate(out);

        out.write("Load_Const R2, 1\n");
        out.write("Add R1, R2\n");

        out.write("Jump " + petlja + "\n");
        out.write(kraj + ":\n");
    }   

}