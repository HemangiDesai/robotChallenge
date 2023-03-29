package com.carvallegro.toyrobot.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GridTest {

    @Test
    void place_should_throw_IllegalArgumentException__no_coordinate_are_set() {
     
        Grid grid = new Grid();

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> grid.place(null, null));

        assertEquals("No Coordinates are set", exception.getMessage());
    }

    @Test
    void place_should_throw_IllegalArgumentException__coordinate_do_not_have_x_value() {
     
        Grid grid = new Grid();
        Coordinates initialCoordinates = new Coordinates(null, 0);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> grid.place(initialCoordinates, null));

        assertEquals("Coordinates are invalid", exception.getMessage());
    }

    @Test
    void place_should_throw_IllegalArgumentException__coordinate_do_not_have_y_value() {
        
        Grid grid = new Grid();
        Coordinates initialCoordinates = new Coordinates(0, null);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> grid.place(initialCoordinates, null));

        assertEquals("Coordinates are invalid", exception.getMessage());
    }

    @Test
    void place_should_throw_IllegalArgumentException__x_is_negative() {
     
        Grid grid = new Grid();
        Coordinates initialCoordinates = new Coordinates(-1, 1);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> grid.place(initialCoordinates, null));

        assertEquals("Coordinates are invalid", exception.getMessage());
    }

    @Test
    void place_should_throw_IllegalArgumentException__y_is_negative() {
         
        Grid grid = new Grid();
        Coordinates initialCoordinates = new Coordinates(0, -1);

         
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> grid.place(initialCoordinates, null));

         
        assertEquals("Coordinates are invalid", exception.getMessage());
    }

    @Test
    void place_should_throw_IllegalArgumentException__x_is_out_of_width_bounds() {
         
        Grid grid = new Grid();
        Coordinates initialCoordinates = new Coordinates(10000, 1);

         
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> grid.place(initialCoordinates, null));

         
        assertEquals("Coordinates are invalid", exception.getMessage());
    }

    @Test
    void place_should_throw_IllegalArgumentException__y_is_out_of_height_bounds() {
         
        Grid grid = new Grid();
        Coordinates initialCoordinates = new Coordinates(1, 10000);

         
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> grid.place(initialCoordinates, null));

         
        assertEquals("Coordinates are invalid", exception.getMessage());
    }

    @Test
    void place_should_throw_IllegalArgumentException__no_direction_is_set() {
         
        Grid grid = new Grid();
        Coordinates initialCoordinates = new Coordinates(0, 0);

         
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> grid.place(initialCoordinates, null));

         
        assertEquals("No direction is set", exception.getMessage());
    }

    @Test
    void place_should_set_Robot_to_appropriate_coordinates_and_direction() {
         
        Grid grid = new Grid();
        Coordinates initialCoordinates = new Coordinates(0, 0);
        Direction direction = Direction.EAST;

         
        grid.place(initialCoordinates, direction);

         
        assertEquals(grid.getRobotCoordinates(), initialCoordinates);
        assertEquals(grid.getRobotDirection(), direction);
    }

    @Test
    void move_should_throw_IllegalStateException_if_robot_has_not_been_placed() {
         
        Grid grid = new Grid();

         
        Throwable exception = assertThrows(IllegalStateException.class, () -> grid.move());

         
        assertEquals("Robot hasn't been placed", exception.getMessage());
    }

    @Test
    public void move_should_throw_IllegalStateException_if_the_robot_is_facing_the_western_edge() {
         
        Grid grid = new Grid();
        Coordinates initialCoordinates = new Coordinates(0, 0);
        Direction direction = Direction.WEST;

         
        grid.place(initialCoordinates, direction);
        Throwable exception = assertThrows(IllegalStateException.class, () -> grid.move());

         
        assertEquals("The robot will fall", exception.getMessage());
        assertEquals(initialCoordinates, grid.getRobotCoordinates());
    }

    @Test
    public void move_should_throw_IllegalStateException_if_the_robot_is_facing_the_southern_edge() {
         
        Grid grid = new Grid();
        Coordinates initialCoordinates = new Coordinates(0, 0);
        Direction direction = Direction.SOUTH;

         
        grid.place(initialCoordinates, direction);
        Throwable exception = assertThrows(IllegalStateException.class, () -> grid.move());

         
        assertEquals("The robot will fall", exception.getMessage());
        assertEquals(initialCoordinates, grid.getRobotCoordinates());
    }

    @Test
    public void move_should_throw_IllegalStateException_if_the_robot_is_facing_the_eastern_edge() {
         
        Grid grid = new Grid();
        Coordinates initialCoordinates = new Coordinates(4, 0);
        Direction direction = Direction.EAST;

         
        grid.place(initialCoordinates, direction);
        Throwable exception = assertThrows(IllegalStateException.class, () -> grid.move());

         
        assertEquals("The robot will fall", exception.getMessage());
        assertEquals(initialCoordinates, grid.getRobotCoordinates());
    }

    @Test
    public void move_should_throw_IllegalStateException_if_the_robot_is_facing_the_northern_edge() {
         
        Grid grid = new Grid();
        Coordinates initialCoordinates = new Coordinates(4, 4);
        Direction direction = Direction.NORTH;

         
        grid.place(initialCoordinates, direction);
        Throwable exception = assertThrows(IllegalStateException.class, () -> grid.move());

         
        assertEquals("The robot will fall", exception.getMessage());
        assertEquals(initialCoordinates, grid.getRobotCoordinates());
    }

    @Test
    public void move_should_move_the_robot_towards_the_east__facing_east() {
         
        Grid grid = new Grid();
        Coordinates coordinates = new Coordinates(0, 0);
        Direction direction = Direction.EAST;
        Coordinates expected = new Coordinates(1, 0);

         
        grid.place(coordinates, direction);
        grid.move();

         
        assertEquals(expected, grid.getRobotCoordinates());
    }

    @Test
    void left_should_throw_IllegalStateException_if_robot_has_not_been_placed() {
         
        Grid grid = new Grid();

         
        Throwable exception = assertThrows(IllegalStateException.class, () -> grid.left());

         
        assertEquals("Robot hasn't been placed", exception.getMessage());
    }

    @Test
    public void left_should_rotate_the_robot_to_the_west__facing_north() {
         
        Grid grid = new Grid();
        Coordinates coordinates = new Coordinates(0, 0);
        Direction direction = Direction.NORTH;
        Direction expected = Direction.WEST;

         
        grid.place(coordinates, direction);
        grid.left();

         
        assertEquals(expected, grid.getRobotDirection());
    }


    @Test
    void right_should_throw_IllegalStateException_if_robot_has_not_been_placed() {
         
        Grid grid = new Grid();

         
        Throwable exception = assertThrows(IllegalStateException.class, () -> grid.right());

         
        assertEquals("Robot hasn't been placed", exception.getMessage());
    }

    @Test
    public void right_should_rotate_the_robot_to_the_east__facing_north() {
         
        Grid grid = new Grid();
        Coordinates coordinates = new Coordinates(0, 0);
        Direction direction = Direction.NORTH;
        Direction expected = Direction.EAST;

         
        grid.place(coordinates, direction);
        grid.right();

         
        assertEquals(expected, grid.getRobotDirection());
    }


    @Test
    void report_should_return_message_if_robot_has_not_been_placed() {
         
        Grid grid = new Grid();

         
        String actual = grid.report();

         
        assertEquals("Robot hasn't been placed", actual);
    }

    @Test
    void report_should_return_robot_position_and_facing_direction() {
         
        Grid grid = new Grid();
        Coordinates coordinates = new Coordinates(0, 0);
        Direction direction = Direction.NORTH;
        String expected = "0,0,NORTH";

         
        grid.place(coordinates, direction);
        String actual = grid.report();

         
        assertEquals(expected, actual);
    }
}