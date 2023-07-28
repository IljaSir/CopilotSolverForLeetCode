class Solution {
public:
    int minimizeXor(int num1, int num2) {
        
        int ans = 0;
        int n = num2;
        int i = 0;
        while (n) {
            if (n & 1) {
                ans |= 1 << i;
            }
            else {
                if (num1 & (1 << i)) {
                    ans |= 1 << i;
                }
            }
            ++i;
            n >>= 1;
        }
        return ans;
    }
};