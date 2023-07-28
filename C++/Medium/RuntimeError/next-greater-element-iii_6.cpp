class Solution {
public:
    int nextGreaterElement(int n) {
        
        vector<int> digits;
        while (n > 0) {
            digits.push_back(n % 10);
            n /= 10;
        }
        int i = 0;
        for (; i < digits.size() - 1; ++i) {
            if (digits[i] > digits[i + 1]) {
                break;
            }
        }
        if (i == digits.size() - 1) {
            return -1;
        }
        int j = i + 1;
        for (; j < digits.size(); ++j) {
            if (digits[j] > digits[i + 1]) {
                break;
            }
        }
        swap(digits[i], digits[j]);
        sort(digits.begin(), digits.begin() + i);
        long long ans = 0;
        for (int i = digits.size() - 1; i >= 0; --i) {
            ans = ans * 10 + digits[i];
        }
        if (ans >= INT_MAX) {
            return -1;
        }
        return ans;
    }
};