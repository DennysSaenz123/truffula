# Truffula Notes
As part of Wave 0, please fill out notes for each of the below files. They are in the order I recommend you go through them. A few bullet points for each file is enough. You don't need to have a perfect understanding of everything, but you should work to gain an idea of how the project is structured and what you'll need to implement. Note that there are programming techniques used here that we have not covered in class! You will need to do some light research around things like enums and and `java.io.File`.

PLEASE MAKE FREQUENT COMMITS AS YOU FILL OUT THIS FILE.

## App.java
Flags: -h(shows hidden files), -nc (shows files with pain white text)
Path: The absolute or relative path to the directory whose contents will be printed.

## ConsoleColor.java
Purpose: Enum of ANSI escape codes for setting console text color (BLACK, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE).
Usage: Put the color code before the text and RESET ("\033[0m") after it, or the color carries into all later output.
Caveat: Works only in terminals that support ANSI codes


## ColorPrinter.java / ColorPrinterTest.java

## TruffulaOptions.java / TruffulaOptionsTest.java

## TruffulaPrinter.java / TruffulaPrinterTest.java

## AlphabeticalFileSorter.java