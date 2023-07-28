class Solution {
public:
    bool isRobotBounded(string instructions) {
        
        int x = 0, y = 0;
        int dx = 0, dy = 1;
        for (char c : instructions) {
            if (c == 'G') {
                x += dx;
                y += dy;
            } else if (c == 'L') {
                int t = dx;
                dx = -dy;
                dy = t;
            } else {
                int t = dx;
                dx = dy;
                dy = -t;
            }
        }
        return (x == 0 && y == 0) || (dx != 0 || dy != 1);
    }
};