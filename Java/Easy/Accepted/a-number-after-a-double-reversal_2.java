class Solution {
    public boolean isSameAfterReversals(int num) {
        
        int reversed1 = reverse(num);
        int reversed2 = reverse(reversed1);
        return reversed2 == num;
    }
    
    private int reverse(int num) {
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }
}