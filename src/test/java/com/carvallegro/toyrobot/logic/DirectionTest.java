package com.carvallegro.toyrobot.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void moveTowards_NORTH_should_return_0_1() {
       
        final Coordinates coordinates = new Coordinates(0, 0);
        final Coordinates expected = new Coordinates(0, 1);

        final Coordinates actual = Direction.NORTH.moveTowards(coordinates);

        assertEquals(expected, actual);
    }

    @Test
    void moveTowards_EAST_should_return_1_0() {
       
        final Coordinates coordinates = new Coordinates(0, 0);
        final Coordinates expected = new Coordinates(1, 0);

        final Coordinates actual = Direction.EAST.moveTowards(coordinates);

        assertEquals(expected, actual);
    }

    @Test
    void moveTowards_SOUTH_should_return_0_minus_1() {
    
        final Coordinates coordinates = new Coordinates(0, 0);
        final Coordinates expected = new Coordinates(0, -1);

        final Coordinates actual = Direction.SOUTH.moveTowards(coordinates);

        assertEquals(expected, actual);
    }

    @Test
    void moveTowards_WEST_should_return_minus_1_0() {
      
        final Coordinates coordinates = new Coordinates(0, 0);
        final Coordinates expected = new Coordinates(-1, 0);

        final Coordinates actual = Direction.WEST.moveTowards(coordinates);

        assertEquals(expected, actual);
    }

    @Test
    void find_should_return_the_correct_command() {
       
        String command = "NORTH";
        Direction expected = Direction.NORTH;
		
        Direction actual = Direction.find(command);

        assertEquals(expected, actual);
    }

    @Test
    void find_should_return_null_when_string_is_empty() {
     
        String command = "";

        Direction actual = Direction.find(command);

        assertNull(actual);
    }

    @Test
    void find_should_return_null_when_command_is_unknown() {
       
        String command = "not a command";

        Direction actual = Direction.find(command);

        assertNull(actual);
    }
}