class Solution {
public:
    int passThePillow(int n, int time) {
        
        int i = time % (2 * n - 2);
        if (i == 0) return n;
        if (i <= n) return i;
        return 2 * n - i;
    }
};