class Solution {
public:
    int smallestEvenMultiple(int n) {
        
        int res = 1;
        for (int i = 1; i <= n; ++i) {
            res = lcm(res, i);
        }
        return res;
    }
};