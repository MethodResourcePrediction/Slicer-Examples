package de.uniks.methodresourceprediction.slicer.examples;

import com.ibm.wala.shrikeCT.InvalidClassFileException;
import de.uniks.vs.methodresourceprediction.slicer.Slicer;
import java.io.IOException;
import java.util.Set;
import org.jgrapht.io.ExportException;

public class SliceExample extends ExampleHelper {
  public static void main(String[] args)
      throws IOException, InterruptedException, ExportException, InvalidClassFileException {
    // Define the signature of method
    String signature =
        "org.mariadb.jdbc.ClientSidePreparedStatement.getMetaData()Ljava/sql/ResultSetMetaData;";

    // Create a Slicer object with jar file and signature
    Slicer slicer = new Slicer();
    slicer.setInputJar(JAR_FILE);
    slicer.setMethodSignature(signature);

    // Set one or more slicing criterions
    slicer.setInstructionIndexes(Set.of(7));

    System.out.println(slicer.getSliceResult());
  }
}
