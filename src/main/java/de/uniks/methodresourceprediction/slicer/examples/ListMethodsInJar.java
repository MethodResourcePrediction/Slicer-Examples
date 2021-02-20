package de.uniks.methodresourceprediction.slicer.examples;

import com.ibm.wala.ipa.cha.ClassHierarchyException;
import de.uniks.vs.methodresourceprediction.utils.Utilities;
import java.io.IOException;
import java.util.List;

public class ListMethodsInJar extends ExampleHelper {
  public static void main(String[] args) throws IOException, ClassHierarchyException {
    List<String> methodSignatures = Utilities.getMethodSignatures(EXCLUSION_FILE, JAR_FILE);

    methodSignatures.stream()
        .filter(ms -> ms.startsWith("org.mariadb.jdbc."))
        .forEach(System.out::println);
  }
}
