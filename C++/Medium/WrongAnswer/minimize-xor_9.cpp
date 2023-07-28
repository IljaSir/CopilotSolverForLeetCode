class Solution {
public:
    int minimizeXor(int num1, int num2) {
        
        int x = num1 ^ num2;
        int i = 0;
        while (x > 0) {
            int t = x >> i;
            if (t & 1) {
                break;
            }
            ++i;
        }
        return num1 | (1 << i);
    }
};