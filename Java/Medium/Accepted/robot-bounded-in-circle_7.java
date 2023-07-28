class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int x = 0;
        int y = 0;
        int direction = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char instruction = instructions.charAt(i);
            switch (instruction) {
                case 'G':
                    switch (direction) {
                        case 0:
                            y++;
                            break;
                        case 1:
                            x++;
                            break;
                        case 2:
                            y--;
                            break;
                        case 3:
                            x--;
                            break;
                    }
                    break;
                case 'L':
                    direction = (direction + 3) % 4;
                    break;
                case 'R':
                    direction = (direction + 1) % 4;
                    break;
            }
        }
        return (x == 0 && y == 0) || direction != 0;
    }
}