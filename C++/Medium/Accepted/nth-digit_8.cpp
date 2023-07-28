class Solution {
public:
    int findNthDigit(int n) {
        
        long long num = 9;
        int len = 1;
        while (n > num * len) {
            n -= num * len;
            num *= 10;
            len++;
        }
        int i = (n - 1) / len;
        int j = (n - 1) % len;
        return to_string(num / 9 + i)[j] - '0';
    }
};