class Solution {
    public int minimizeXor(int num1, int num2) {
        
        int xor = num1 ^ num2;
        int bit = 1;
        int res = 0;
        while (xor > 0) {
            if ((xor & 1) == 1) {
                res |= bit;
            }
            bit <<= 1;
            xor >>= 1;
        }
        return res;
    }
}