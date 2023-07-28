class Solution {
public:
    int countDigitOne(int n) {
        
        if (n <= 0) return 0;
        if (n < 10) return 1;
        int d = 1;
        while ((n / d) >= 10) d *= 10;
        int high = n / d;
        int low = n % d;
        if (high == 1) {
            return countDigitOne(d - 1) + countDigitOne(low) + low + 1;
        } else {
            return countDigitOne(d - 1) * high + countDigitOne(low) + d;
        }
    }
};