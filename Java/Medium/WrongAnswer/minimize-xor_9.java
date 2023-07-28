class Solution {
    public int minimizeXor(int num1, int num2) {
        
        int x = num2 ^ num1;
        int n = Integer.bitCount(x);
        return num1 ^ ((1 << n) - 1);
    }
}