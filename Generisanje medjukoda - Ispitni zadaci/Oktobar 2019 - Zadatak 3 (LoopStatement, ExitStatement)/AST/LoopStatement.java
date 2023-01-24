package AST;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LoopStatement extends Statement {

    ArrayList<Statement> statementList;

    public LoopStatement(ArrayList<Statement> statementList) {
        this.statementList = statementList;
    }

    @Override
    public void translate(BufferedWriter out) throws IOException {
        String petlja = genLab();
        String kraj = genLab();
        
        out.write(petlja + ":\n");
        for (Statement s : statementList) {
            if (s instanceof ExitStatement) {
                ((ExitStatement)s).endLabel = kraj;
            }

            s.translate(out);
        }

        out.write("Jump " + petlja + "\n");
        out.write(kraj + ":\n");
    }
}