package com.carvallegro.toyrobot.cli;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void find_should_return_the_correct_command() {
        
        String command = "LEFT";
        Command expected = Command.LEFT;

        
        Command actual = Command.find(command);

        
        assertEquals(expected, actual);
    }

    @Test
    void find_should_return_UNKNOWN_when_string_is_empty() {
       
        String command = "";
        Command expected = Command.UNKNOWN;

        
        Command actual = Command.find(command);

       
        assertEquals(expected, actual);
    }

    @Test
    void find_should_return_UNKNOWN_when_command_is_unknown() {
       
        String command = "not a command";
        Command expected = Command.UNKNOWN;

       
        Command actual = Command.find(command);

     
        assertEquals(expected, actual);
    }
}