class Solution {
public:
    int findNthDigit(int n) {
        
        int base = 1, digit = 1;
        long long count = 9;
        while (n > count) {
            n -= count;
            base *= 10;
            digit += 1;
            count = base * digit * 9;
        }
        int num = base + (n - 1) / digit;
        string s = to_string(num);
        return s[(n - 1) % digit] - '0';
    }
};