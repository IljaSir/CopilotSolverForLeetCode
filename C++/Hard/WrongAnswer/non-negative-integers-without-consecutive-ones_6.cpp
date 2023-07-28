class Solution {
public:
    int findIntegers(int n) {
        
        int a = 1, b = 1, c = 0;
        for (int i = 1; i < 31; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        int res = 0, pre = 0;
        for (int i = 29; i >= 0; i--) {
            int val = 1 << i;
            if (n & val) {
                n -= val;
                res += b;
                if (pre == 1) {
                    res -= 1;
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }
            if (i == 0) {
                res += 1;
            }
        }
        return res;
    }
};