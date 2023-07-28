class Solution {
public:
    int countNumbersWithUniqueDigits(int n) {
        
        if (n == 0) return 1;
        if (n == 1) return 10;
        int res = 10, base = 9;
        for (int i = 2; i <= n; i++) {
            base *= (9 - i + 2);
            res += base;
        }
        return res;
    }
};