class Solution {
public:
    int passThePillow(int n, int time) {
        
        int ans = time % (2 * n - 2);
        if (ans == 0) return n;
        if (ans > n) return 2 * n - ans;
        return ans;
    }
};