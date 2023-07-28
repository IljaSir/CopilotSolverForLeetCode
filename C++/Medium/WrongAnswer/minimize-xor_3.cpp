class Solution {
public:
    int minimizeXor(int num1, int num2) {
        
        int mask = 1;
        int result = 0;
        while (mask <= num1) {
            if ((num1 & mask) != (num2 & mask)) {
                result |= mask;
            }
            mask <<= 1;
        }
        return result;
    }
};