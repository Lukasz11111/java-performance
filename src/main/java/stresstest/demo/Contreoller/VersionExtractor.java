package stresstest.demo.Contreoller;

import java.io.IOException;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class VersionExtractor {

    public static String extractVersion(
            final Class<?> referenceClass) {
        return Optional.ofNullable(referenceClass)
                .map(cls -> unthrow(cls::getProtectionDomain))
                .map(ProtectionDomain::getCodeSource)
                .map(CodeSource::getLocation)
                .get().toString();
    }

    private static Properties readPomProperties(
            final JarInputStream jarInputStream,
            final Class<?> referenceClass) {

        try {
            JarEntry jarEntry;
            while ((jarEntry = jarInputStream.getNextJarEntry()) != null) {
                String entryName = jarEntry.getName();
                if (entryName.startsWith("META-INF")
                        && entryName.endsWith("pom.properties")) {

                    Properties properties = new Properties();
                    ClassLoader classLoader = referenceClass.getClassLoader();
                    properties.load(classLoader.getResourceAsStream(entryName));
                    return properties;
                }
            }
        } catch (IOException ignored) { }
        return null;
    }

    private static <T> T unthrow(final Callable<T> code) {
        try {
            return code.call();
        } catch (Exception ignored) { return null; }
    }

}
