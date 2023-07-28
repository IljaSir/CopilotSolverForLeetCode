class Solution {
    public boolean isSameAfterReversals(int num) {
        
        int reversed = 0;
        int original = num;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        int reversed2 = 0;
        while (reversed > 0) {
            reversed2 = reversed2 * 10 + reversed % 10;
            reversed /= 10;
        }
        return original == reversed2;
    }
}