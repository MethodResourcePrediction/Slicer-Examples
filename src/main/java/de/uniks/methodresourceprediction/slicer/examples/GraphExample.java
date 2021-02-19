package de.uniks.methodresourceprediction.slicer.examples;

import com.ibm.wala.shrikeCT.InvalidClassFileException;
import de.uniks.vs.methodresourceprediction.slicer.ControlFlow;
import de.uniks.vs.methodresourceprediction.slicer.Slicer;
import org.jgrapht.io.ExportException;

import java.io.IOException;

public class GraphExample extends ExampleHelper {
  public static void main(String[] args)
      throws IOException, InterruptedException, ExportException, InvalidClassFileException {
    // Define the signature of method
    String signature =
        "org.mariadb.jdbc.ClientSidePreparedStatement.getMetaData()Ljava/sql/ResultSetMetaData;";

    // Create a Slicer object with jar file and signature
    Slicer slicer = new Slicer();
    slicer.setInputJar(JAR_FILE);
    slicer.setMethodSignature(signature);

    // Print a method summary (the bytecode instructions)
    System.out.println(slicer.getMethodSummary());

    // Show the control flow graph
    ControlFlow controlFlow = slicer.getControlFlow();
    System.out.println(controlFlow);
    controlFlow.showPlot();

    // Other graphs are supported
    //    slicer.getControlDependency().showPlot();
    //    slicer.getBlockDependency().showPlot();
    //    slicer.getDataDependency().showPlot();
    //    slicer.getArgumentDependency().showPlot();
    //    slicer.getClassObjectDependency().showPlot();

    // Dominance graphs
    //    slicer.getPostDominance().showPlot();
    //    slicer.getStrictDominance().showPlot();
    //    slicer.getStrictPostDominance().showPlot();
    //    slicer.getImmediateDominance().showPlot();
    //    slicer.getImmediatePostDominance().showPlot();
  }
}
