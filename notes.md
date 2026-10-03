# Truffula Notes
As part of Wave 0, please fill out notes for each of the below files. They are in the order I recommend you go through them. A few bullet points for each file is enough. You don't need to have a perfect understanding of everything, but you should work to gain an idea of how the project is structured and what you'll need to implement. Note that there are programming techniques used here that we have not covered in class! You will need to do some light research around things like enums and and `java.io.File`.

PLEASE MAKE FREQUENT COMMITS AS YOU FILL OUT THIS FILE.

## App.java
Flags: -h(shows hidden files), -nc (shows files with pain white text)
Path: The absolute or relative path to the directory whose contents will be printed.

## ConsoleColor.java
Purpose: Enum of ANSI escape codes for setting console text color (BLACK, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE).
Usage: Put the color code before the text and RESET ("\033[0m") after it, or the color carries into all later output.
Limitation: Works only in terminals that support ANSI codes


## ColorPrinter.java / ColorPrinterTest.java
Purpose: Prints colored text to any PrintStream using ANSI escape codes.
How it works: Set a color with setCurrentColor() using the ConsoleColor enum, then print. The color either resets after each print or stays on, depending on the parameters.
Limitation: Colors only appear in terminals that support ANSI codes

## TruffulaOptions.java / TruffulaOptionsTest.java
Purpose: Holds the settings for printing a directory tree: show hidden files, use color, and the root directory.
Arguments: -h -nc path. -h shows hidden files (names starting with .), -nc turns off color (on by default). Flags can go in any order, and the path is required.
Errors: IllegalArgumentException for unknown flags or a missing path; FileNotFoundException if the path doesn't exist or isn't a directory.

## TruffulaPrinter.java / TruffulaPrinterTest.java
Purpose: Prints a directory tree, sorting files and folders case-insensitively and cycling through colors (likely one per depth level) to make it easier to read.
Fields: TruffulaOptions (hidden files, color, root), a color sequence (default: WHITE → PURPLE → YELLOW), and a ColorPrinter for output.
Constructors: Four overloads that all lead to the full one. You only have to pass options; the output stream (defaults to System.out) and color sequence (defaults to the list above) are optional, which makes it easy to send output elsewhere for testing

## AlphabeticalFileSorter.java