package edu.ccrm.config;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Singleton configuration class for the CCRM application.
 * Follows the Singleton pattern to ensure only one instance exists.
 */
public class AppConfig {
    private static AppConfig instance;
    private final Path dataDirectory;
    private final Path backupDirectory;
    private final int maxCreditsPerSemester;
    private final boolean assertionsEnabled;

    private AppConfig() {
        // Initialize with default values
        this.dataDirectory = Paths.get(System.getProperty("user.home"), "ccrm", "data");
        this.backupDirectory = Paths.get(System.getProperty("user.home"), "ccrm", "backups");
        this.maxCreditsPerSemester = 21;
        
        // Check if assertions are enabled
        boolean assertionsEnabled = false;
        try {
            assert false;
        } catch (AssertionError e) {
            assertionsEnabled = true;
        }
        this.assertionsEnabled = assertionsEnabled;
    }

    /**
     * Gets the singleton instance of AppConfig.
     * Creates it if it doesn't exist (lazy initialization).
     *
     * @return The singleton instance
     */
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public Path getDataDirectory() {
        return dataDirectory;
    }

    public Path getBackupDirectory() {
        return backupDirectory;
    }

    public int getMaxCreditsPerSemester() {
        return maxCreditsPerSemester;
    }

    public boolean isAssertionsEnabled() {
        return assertionsEnabled;
    }

    /**
     * Prints system configuration information.
     */
    public void printSystemInfo() {
        System.out.println("\nSystem Configuration:");
        System.out.println("-------------------");
        System.out.println("Data Directory: " + dataDirectory);
        System.out.println("Backup Directory: " + backupDirectory);
        System.out.println("Max Credits Per Semester: " + maxCreditsPerSemester);
        System.out.println("Assertions: " + (assertionsEnabled ? "Enabled" : "Disabled"));
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("OS: " + System.getProperty("os.name"));
    }
}