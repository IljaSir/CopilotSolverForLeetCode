class Solution {
public:
    int passThePillow(int n, int time) {
        
        int dir = 1;
        int pos = 1;
        for (int i = 1; i < time; ++i) {
            pos += dir;
            if (pos == n) {
                dir = -1;
            } else if (pos == 1) {
                dir = 1;
            }
        }
        return pos;
    }
};