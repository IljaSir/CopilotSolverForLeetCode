class Solution {
public:
    long long smallestNumber(long long num) {
        
        if (num == 0) return 0;
        bool isNeg = false;
        if (num < 0) {
            isNeg = true;
            num = -num;
        }
        vector<int> digits;
        while (num > 0) {
            digits.push_back(num % 10);
            num /= 10;
        }
        sort(digits.begin(), digits.end());
        long long res = 0;
        for (int i = 0; i < digits.size(); ++i) {
            res = res * 10 + digits[i];
        }
        if (isNeg) res = -res;
        return res;
    }
};