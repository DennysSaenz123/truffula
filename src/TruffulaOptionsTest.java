import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class TruffulaOptionsTest {

  @Test
  void testValidDirectoryIsSet(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-nc", "-h", directoryPath};

    // Act: Create TruffulaOptions instance
    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Check that the root directory is set correctly
    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertTrue(options.isShowHidden());
    assertFalse(options.isUseColor());
  }

    @Test
  void testDefaultsWithOnlyPath(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Only the path, no flags
    String[] args = {tempDir.getAbsolutePath()};

    // Act
    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Color on, hidden files off by default
    assertEquals(tempDir.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertFalse(options.isShowHidden());
    assertTrue(options.isUseColor());
  }

  @Test
  void testUnknownFlagThrowsException(@TempDir File tempDir) {
    // Arrange: Invalid flag before a valid path
    String[] args = {"-x", tempDir.getAbsolutePath()};

    // Act + Assert
    assertThrows(IllegalArgumentException.class, () -> new TruffulaOptions(args));
  }
}
