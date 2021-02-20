package de.uniks.methodresourceprediction.slicer.examples;

import com.ibm.wala.shrikeCT.InvalidClassFileException;
import de.uniks.vs.methodresourceprediction.slicer.Slicer;
import java.io.IOException;
import java.util.Set;
import org.apache.commons.codec.DecoderException;
import org.jgrapht.io.ExportException;

public class ExecutableSliceExample extends ExampleHelper {
  public static void main(String[] args)
      throws IOException, InterruptedException, ExportException, InvalidClassFileException,
          DecoderException {
    // Define the signature of method
    String signature =
        "org.mariadb.jdbc.ClientSidePreparedStatement.getMetaData()Ljava/sql/ResultSetMetaData;";

    // Create a Slicer object with jar file and signature
    Slicer slicer = new Slicer();
    slicer.setInputJar(JAR_FILE);
    slicer.setMethodSignature(signature);

    // Set one or more slicing criterions
    slicer.setInstructionIndexes(Set.of(7));

    // Define where required additional jars can be found
    //  These jars are needed to add functionalities to the resulting sliced file
    slicer.setAdditionalJarsPath("src/main/resources/");

    // Set the slice output jar file name
    slicer.setOutputJar("mariadb-java-client-2.7.2-sliced.jar");

    // Slice and generate an executable jar
    slicer.makeSlicedFile();
  }
}
