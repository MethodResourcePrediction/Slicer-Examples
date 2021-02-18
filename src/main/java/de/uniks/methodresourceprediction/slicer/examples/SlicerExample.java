package de.uniks.methodresourceprediction.slicer.examples;

import com.ibm.wala.ipa.cha.ClassHierarchyException;
import com.ibm.wala.shrikeCT.InvalidClassFileException;
import de.uniks.vs.methodresourceprediction.slicer.Slicer;
import de.uniks.vs.methodresourceprediction.utils.Utilities;
import org.jgrapht.io.ExportException;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SlicerExample {
  static final String EXCLUSION_FILE = "src/main/resources/Java60RegressionExclusions.txt";
  static final String JAR_FILE = "src/main/resources/mariadb-java-client-2.7.2.jar";

  public static void main(String[] args)
      throws IOException, ClassHierarchyException, InterruptedException, ExportException,
          InvalidClassFileException {
    List<String> methodSignatures = Utilities.getMethodSignatures(EXCLUSION_FILE, JAR_FILE);

    List<String> mariadbMethodSignatures =
        methodSignatures.stream().filter(ms -> ms.contains("mariadb")).collect(Collectors.toList());
    Collections.shuffle(mariadbMethodSignatures);

    System.out.println("Select a signature:");
    for (int i = 0; i < mariadbMethodSignatures.size() && i < 5; i++) {
      System.out.println("  " + i + ": " + mariadbMethodSignatures.get(i));
    }

    Scanner scanner = new Scanner(System.in);
    System.out.print("Select a signature [int]: ");
    int selection = scanner.nextInt();

    String signature = mariadbMethodSignatures.get(selection);

    Slicer slicer = new Slicer();
    slicer.setInputJar(JAR_FILE);
    slicer.setMethodSignature(signature);

    slicer.getBlockDependency().showPlot();
  }
}
