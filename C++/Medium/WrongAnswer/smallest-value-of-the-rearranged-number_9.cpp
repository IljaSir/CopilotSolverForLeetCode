class Solution {
public:
    long long smallestNumber(long long num) {
        
        long long val = 0;
        int sign = num < 0 ? -1 : 1;
        num = abs(num);
        vector<int> digits;
        while (num) {
            digits.push_back(num % 10);
            num /= 10;
        }
        sort(digits.begin(), digits.end());
        for (int i = 0; i < digits.size(); i++) {
            val = val * 10 + digits[i];
        }
        return val * sign;
    }
};