class Solution {
public:
    int passThePillow(int n, int time) {
        
        int t = time % (2 * n - 2);
        if (t == 0) {
            return n;
        }
        if (t <= n) {
            return t;
        }
        return 2 * n - t;
    }
};