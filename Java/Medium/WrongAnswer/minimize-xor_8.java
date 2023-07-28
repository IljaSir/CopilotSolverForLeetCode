class Solution {
    public int minimizeXor(int num1, int num2) {
        
        int n = num2;
        int k = 1;
        while (n > 0) {
            n >>= 1;
            k <<= 1;
        }
        return num1 & (k - 1);
    }
}