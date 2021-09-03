package loganconnor44.katas;

public class RobotBoundedInCircle {

    public boolean main(String instructions) {
        Direction cardinalDirection = this.createCardinalDirections();
        //0 is x
        //1 is y
        int[] axis = new int[2];
        for (int i = 0; i < 4; i++) {
            cardinalDirection = this.execute(i, cardinalDirection, instructions, axis);
            if (axis[0] == 0 && axis[1] == 0) {
                return true;
            }
        }

        return false;
    }

    public Direction execute(int step, Direction cardinalDirection, String instructions, int[] axis) {
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') {
                cardinalDirection = cardinalDirection.previous;
            } else if (instructions.charAt(i) == 'R') {
                cardinalDirection = cardinalDirection.next;
            } else {
                int x = axis[0];
                int y = axis[1];

                if (cardinalDirection.value == 'N') {
                    y++;
                } else if (cardinalDirection.value == 'E') {
                    x++;
                } else if (cardinalDirection.value == 'S') {
                    y--;
                } else if (cardinalDirection.value == 'W') {
                    x--;
                }

                axis[0] = x;
                axis[1] = y;
            }
        }

        return cardinalDirection;
    }

    public Direction createCardinalDirections() {
        Direction north = new Direction();
        Direction east = new Direction('E');
        Direction south = new Direction('S');
        Direction west = new Direction('W');

        north.previous = west;
        north.next = east;
        
        east.previous = north;
        east.next = south;
        
        south.previous = east;
        south.next = west;

        west.previous = south;
        west.next = north;
        
        return north;
    }

    public class Direction {
        Direction previous;
        char value = 'N';
        Direction next;

        public Direction() {}

        public Direction(char value) {
            this.value = value;
        }
    }
}
