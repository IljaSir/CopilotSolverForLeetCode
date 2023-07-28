class Solution {
    public int minimizeXor(int num1, int num2) {
        
        int x = 0;
        int mask = 1;
        while (mask <= num2) {
            if ((num1 & mask) != (num2 & mask)) {
                x |= mask;
            }
            mask <<= 1;
        }
        return x;
    }
}