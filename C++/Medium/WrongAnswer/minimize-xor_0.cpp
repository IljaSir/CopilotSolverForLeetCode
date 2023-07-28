class Solution {
public:
    int minimizeXor(int num1, int num2) {
        
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 31; ++i) {
            if ((num1 & mask) != (num2 & mask)) {
                res |= mask;
            }
            mask <<= 1;
        }
        return res;
    }
};