class Solution {
public:
    int nextBeautifulNumber(int n) {
        
        int n1 = n;
        vector<int> digits;
        while (n1) {
            digits.push_back(n1 % 10);
            n1 /= 10;
        }
        for (int i = 0; i < digits.size(); ++i) {
            if (digits[i] < 9) {
                digits[i]++;
                for (int j = 0; j < i; ++j) {
                    digits[j] = 0;
                }
                break;
            }
        }
        int res = 0;
        for (int i = digits.size() - 1; i >= 0; --i) {
            res = res * 10 + digits[i];
        }
        return res;
    }
    int nextGreaterElement(int n) {
        int n1 = n;
        vector<int> digits;
        while (n1) {
            digits.push_back(n1 % 10);
            n1 /= 10;
        }
        int i = 1;
        for (; i < digits.size(); ++i) {
            if (digits[i] < digits[i - 1]) {
                break;
            }
        }
        if (i == digits.size()) {
            return -1;
        }
        int digit = digits[i];
        int index = i;
        for (int j = i + 1; j < digits.size(); ++j) {
            if (digits[j] < digit && digits[j] > digits[i]) {
                digit = digits[j];
                index = j;
            }
        }
        swap(digits[i], digits[index]);
        sort(digits.begin(), digits.begin() + i);
        int res = 0;
        for (int i = digits.size() - 1; i >= 0; --i) {
            res = res * 10 + digits[i];
        }
        if (res <= n) {
            return -1;
        }
        return res;
    }
};