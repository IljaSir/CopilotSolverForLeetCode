class Solution {
public:
    int minimizeXor(int num1, int num2) {
        
        int ans = 0;
        int mask = 1;
        for (int i = 0; i < 32; ++i) {
            if ((mask & num1) != (mask & num2)) {
                ans |= mask;
            }
            mask <<= 1;
        }
        return ans;
    }
};