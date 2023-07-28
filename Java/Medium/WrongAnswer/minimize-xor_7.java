class Solution {
    public int minimizeXor(int num1, int num2) {
        
        int x = num1 ^ num2;
        int mask = 1 << 30;
        while (mask != 0 && (x & mask) == 0) {
            mask >>= 1;
        }
        return (num2 & ~mask) | (num1 & mask);
    }
}