class Solution {
public:
    bool judgeCircle(string moves) {
        
        int x = 0, y = 0;
        for (auto ch: moves) {
            if (ch == 'U') ++x;
            if (ch == 'D') --x;
            if (ch == 'L') --y;
            if (ch == 'R') ++y;
        }
        return x == 0 && y == 0;
    }
};