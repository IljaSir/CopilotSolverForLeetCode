class Solution {
public:
    int passThePillow(int n, int time) {
        
        int x = time % (2*n - 2);
        if (x == 0) return n;
        if (x <= n) return x;
        return 2*n - x;
    }
};