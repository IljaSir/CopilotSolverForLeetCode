class Solution {
public:
    long long coloredCells(int n) {
        
        long long res = 0;
        for (int i = 1; i <= n; ++i) {
            res += (n - i + 1) * 2;
        }
        return res;
    }
};