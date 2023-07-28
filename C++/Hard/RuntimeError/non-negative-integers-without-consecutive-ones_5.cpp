class Solution {
public:
    int findIntegers(int n) {
        
        int a = 1, b = 2, c;
        for (int i = 1; i < 32; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        int res = 0, pre_bit = 0;
        for (int i = 30; i >= 0; i--) {
            int bit = (n >> i) & 1;
            if (bit) {
                res += a;
                if (pre_bit) {
                    res--;
                    break;
                }
            }
            pre_bit = bit;
            if (i) a -= b, b -= a;
        }
        return res + 1;
    }
};