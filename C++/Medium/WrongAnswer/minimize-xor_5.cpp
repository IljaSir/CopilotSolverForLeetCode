class Solution {
public:
    int minimizeXor(int num1, int num2) {
        
        int res = num1 ^ num2;
        int mask = 1;
        while (mask <= res) {
            mask <<= 1;
        }
        mask--;
        return num2 & mask;
    }
};