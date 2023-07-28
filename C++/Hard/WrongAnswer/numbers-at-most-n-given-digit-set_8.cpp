class Solution {
public:
    int atMostNGivenDigitSet(vector<string>& digits, int n) {
        
        int len = 0, temp = n;
        while (temp > 0) {
            len++;
            temp /= 10;
        }
        int ans = 0;
        for (int i = 1; i < len; i++) {
            ans += pow(digits.size(), i);
        }
        for (int i = 0; i < len; i++) {
            int digit = n / pow(10, len - i - 1);
            int count = 0;
            for (string d : digits) {
                if (stoi(d) < digit) {
                    count++;
                }
            }
            ans += count * pow(digits.size(), len - i - 1);
            if (count == 0) {
                return ans;
            }
            n %= (int)pow(10, len - i - 1);
        }
        return ans + 1;
    }
};