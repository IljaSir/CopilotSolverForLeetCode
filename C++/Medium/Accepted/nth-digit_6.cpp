class Solution {
public:
    int findNthDigit(int n) {
        
        if (n < 10) return n;
        int i = 1;
        long long cnt = 9;
        while (n > cnt * i) {
            n -= cnt * i;
            cnt *= 10;
            ++i;
        }
        int num = cnt / 9 + (n - 1) / i;
        int pos = (n - 1) % i;
        while (i - 1 - pos) {
            num /= 10;
            --i;
        }
        return num % 10;
    }
};