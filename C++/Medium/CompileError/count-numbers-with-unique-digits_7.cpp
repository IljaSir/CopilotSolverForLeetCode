class Solution {
public:
    int countNumbersWithUniqueDigits(int n) {
        
        int res = 0;
        for (int i = 0; i <= n; ++i) {
            res += count(i);
        }
        return res;
    }
};