class Solution {
public:
    int passThePillow(int n, int time) {
        
        int i, j, k;
        int dir = 1;
        int cur = 1;
        for (i = 0; i < time; i++) {
            cur += dir;
            if (cur == 1 || cur == n) {
                dir = -dir;
            }
        }
        return cur;
    }
};