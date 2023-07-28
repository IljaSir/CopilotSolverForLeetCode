class Solution {
    public int minimizeXor(int num1, int num2) {
        
        int x = 1;
        int res = 0;
        while (x <= num2) {
            if ((num1 & x) != (num2 & x)) {
                res |= x;
            }
            x <<= 1;
        }
        return res;
    }
}