class Solution {
public:
    bool isRobotBounded(string instructions) {
        
        int x = 0, y = 0;
        int dir = 0;
        for (char c: instructions) {
            if (c == 'G') {
                switch (dir) {
                    case 0: y++; break;
                    case 1: x++; break;
                    case 2: y--; break;
                    case 3: x--; break;
                }
            }
            else if (c == 'L') {
                dir = (dir + 3) % 4;
            }
            else if (c == 'R') {
                dir = (dir + 1) % 4;
            }
        }
        return (x == 0 && y == 0) || dir != 0;
    }
};