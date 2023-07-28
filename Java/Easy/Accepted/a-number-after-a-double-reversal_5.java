class Solution {
    public boolean isSameAfterReversals(int num) {
        
        int reversed1 = reverse(num);
        int reversed2 = reverse(reversed1);
        return reversed2 == num;
    }
    public int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
}