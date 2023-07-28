class Solution {
public:
    long long coloredCells(int n) {
        
        long long result = 0;
        for (long long i = 1; i <= n; i++) {
            result += i * 2 + (n - i) * 2;
        }
        return result;
    }
};