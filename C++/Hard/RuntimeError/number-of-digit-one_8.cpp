class Solution {
public:
    int countDigitOne(int n) {
        
        int ans = 0;
        int base = 1;
        while (n >= base) {
            int cur = n % (base * 10) / base;
            int high = n / (base * 10);
            int low = n % base;
            if (cur == 0) {
                ans += high * base;
            } else if (cur == 1) {
                ans += high * base + low + 1;
            } else {
                ans += (high + 1) * base;
            }
            base *= 10;
        }
        return ans;
    }
};