class Solution {
public:
    int consecutiveNumbersSum(int n) {
        
        int count = 0;
        for (int i = 1; i <= n; ++i) {
            if ((2 * n - i * i + i) % (2 * i) == 0) {
                ++count;
            }
        }
        return count;
    }
};