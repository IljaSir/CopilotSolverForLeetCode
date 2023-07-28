class Solution {
public:
    bool isRobotBounded(string instructions) {
        
        int x = 0;
        int y = 0;
        int dir = 0;
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions[i] == 'G') {
                switch (dir) {
                    case 0: y++; break;
                    case 1: x--; break;
                    case 2: y--; break;
                    case 3: x++; break;
                }
            } else if (instructions[i] == 'L') {
                dir = (dir + 1) % 4;
            } else {
                dir = (dir - 1 + 4) % 4;
            }
        }
        return (x == 0 && y == 0) || dir != 0;
    }
};