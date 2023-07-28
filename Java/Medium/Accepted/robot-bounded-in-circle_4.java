class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int x = 0, y = 0, dx = 0, dy = 1;
        for (int i = 0; i < instructions.length(); ++i) {
            if (instructions.charAt(i) == 'G') {
                x += dx;
                y += dy;
            } else if (instructions.charAt(i) == 'L') {
                int tmp = dx;
                dx = -dy;
                dy = tmp;
            } else {
                int tmp = dx;
                dx = dy;
                dy = -tmp;
            }
        }
        return (x == 0 && y == 0) || (dx != 0 || dy != 1);
    }
}