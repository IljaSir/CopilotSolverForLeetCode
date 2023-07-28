class Solution {
public:
    int countNumbersWithUniqueDigits(int n) {
        
        int ans = 1;
        int base = 9;
        for (int i = 1; i <= n; i++) {
            ans += base;
            base *= (10 - i);
        }
        return ans;
    }
};