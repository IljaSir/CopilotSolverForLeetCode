class Solution {
public:
    int findNthDigit(int n) {
        
        int i = 1;
        long long int k = 1;
        while (n > i * k * 9) {
            n -= i * k * 9;
            i++;
            k *= 10;
        }
        int t = n / i;
        int r = n % i;
        if (r == 0) {
            return (k + t - 1) % 10;
        } else {
            return to_string(k + t)[r - 1] - '0';
        }
    }
};