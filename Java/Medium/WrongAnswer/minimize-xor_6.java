class Solution {
    public int minimizeXor(int num1, int num2) {
        
        int x = num1 ^ num2;
        int n = 0;
        while (x != 0) {
            n += x & 1;
            x >>= 1;
        }
        int res = 0;
        while (n > 0) {
            res = (res << 1) + 1;
            n--;
        }
        return res ^ num1;
    }
}