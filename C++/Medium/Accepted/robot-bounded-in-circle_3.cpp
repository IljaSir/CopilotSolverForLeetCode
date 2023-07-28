class Solution {
public:
    bool isRobotBounded(string instructions) {
        
        int x = 0, y = 0;
        int dx = 0, dy = 1;
        for (int i = 0; i < instructions.size(); i++) {
            if (instructions[i] == 'G') {
                x += dx;
                y += dy;
            } else if (instructions[i] == 'L') {
                int tdx = dx;
                dx = -dy;
                dy = tdx;
            } else {
                int tdx = dx;
                dx = dy;
                dy = -tdx;
            }
        }
        return (x == 0 && y == 0) || (dx != 0 || dy != 1);
    }
};