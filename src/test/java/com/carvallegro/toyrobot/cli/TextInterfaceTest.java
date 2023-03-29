package com.carvallegro.toyrobot.cli;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TextInterfaceTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    private TextInterface textInterface;

    @BeforeEach
    public void beforeEach() {
        textInterface = new TextInterface();
    }

    @BeforeAll
    public static void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public static void restore() {
        System.setOut(originalOut);
    }

    @Test
    void runCommand_throw_exception_when_robot_have_not_been_placed() {
       
        String command = "move";

        Throwable exception = assertThrows(IllegalStateException.class, () -> textInterface.runCommand(command, null));

        assertEquals("Robot hasn't been placed", exception.getMessage());
    }

    @Test
    void runCommand_throw_exception_when_PLACE_has_null_arguments() {
      
        String command = "place";

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> textInterface.runCommand(command, null));

        assertEquals("The PLACE command must have three parameters: X,Y,DIRECTION", exception.getMessage());
    }

    @Test
    void runCommand_throw_exception_when_PLACE_has_invalid_number_of_arguments() {
       
        String command = "place";
        String[] params = new String[]{"a", "b"};

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> textInterface.runCommand(command, params));

        assertEquals("The PLACE command must have three parameters: X,Y,DIRECTION", exception.getMessage());
    }

    @Test
    void runCommand_throw_exception_when_PLACE_has_invalid_coordinate_params() {
       
        String command = "place";
        String[] params = new String[]{"a", "b", "c"};

      
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> textInterface.runCommand(command, params));

        assertEquals("Coordinates must be integers", exception.getMessage());
    }

    @Test
    void runCommand_REPORT_should_print_robot_state() {
    
        String[] params = new String[]{"0", "0", "NORTH"};
        String expected = "0,0,NORTH";

        textInterface.runCommand(Command.PLACE.name(), params);
        textInterface.runCommand(Command.REPORT.name(), null);
        String actual = outContent.toString();

        assertEquals(actual.trim(), expected);
    }

    @Test
    void runCommand_LEFT_should_print_nothing() {
      
        String[] params = new String[]{"0", "0", "NORTH"};

        textInterface.runCommand(Command.PLACE.name(), params);
        textInterface.runCommand(Command.LEFT.name(), null);

        assertEquals("", outContent.toString());
    }

    @Test
    void runCommand_RIGHT_should_print_nothing() {
    
        String[] params = new String[]{"0", "0", "NORTH"};

        textInterface.runCommand(Command.PLACE.name(), params);
        textInterface.runCommand(Command.RIGHT.name(), null);

        assertEquals("", outContent.toString());
    }

    @Test
    void runCommand_MOVE_should_print_nothing() {
     
        String[] params = new String[]{"0", "0", "NORTH"};

        textInterface.runCommand(Command.PLACE.name(), params);
        textInterface.runCommand(Command.MOVE.name(), null);

        assertEquals("", outContent.toString());
    }
}