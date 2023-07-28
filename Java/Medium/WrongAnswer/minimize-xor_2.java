class Solution {
    public int minimizeXor(int num1, int num2) {
        
        return num1 ^ num2 ^ ((num1 ^ num2) | ((num1 ^ num2) - 1));
    }
}