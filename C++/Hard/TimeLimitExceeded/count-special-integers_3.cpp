class Solution {
public:
    int countSpecialNumbers(int n) {
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            int digits = 0;
            int mask = 0;
            while (j > 0) {
                int digit = j % 10;
                if ((mask >> digit) & 1) {
                    break;
                }
                mask |= 1 << digit;
                digits++;
                j /= 10;
            }
            if (j == 0 && digits == __builtin_popcount(mask)) {
                count++;
            }
        }
        return count;
    }
};