class Solution {
public:
    int minimizeXor(int num1, int num2) {
        
        int mask = 1;
        int res = 0;
        while (num2 > 0) {
            if (num2 & 1) {
                res |= mask;
            }
            mask <<= 1;
            num2 >>= 1;
        }
        return res;
    }
};