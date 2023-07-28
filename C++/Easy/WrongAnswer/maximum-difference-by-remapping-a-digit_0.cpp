class Solution {
public:
    int minMaxDifference(int num) {
        
        vector<int> digits;
        int n = num;
        while (n > 0) {
            digits.push_back(n % 10);
            n /= 10;
        }
        reverse(digits.begin(), digits.end());
        int minDigit = *min_element(digits.begin(), digits.end());
        int maxDigit = *max_element(digits.begin(), digits.end());
        int minNum = 0;
        int maxNum = 0;
        for (int i = 0; i < digits.size(); ++i) {
            if (digits[i] == minDigit) {
                minNum = minNum * 10 + maxDigit;
            } else {
                minNum = minNum * 10 + digits[i];
            }
            if (digits[i] == maxDigit) {
                maxNum = maxNum * 10 + minDigit;
            } else {
                maxNum = maxNum * 10 + digits[i];
            }
        }
        return maxNum - minNum;
    }
};