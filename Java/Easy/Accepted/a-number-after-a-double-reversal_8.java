class Solution {
    public boolean isSameAfterReversals(int num) {
        
        int reversed1 = 0;
        int originalNum = num;
        while (num != 0) {
            reversed1 *= 10;
            reversed1 += num % 10;
            num /= 10;
        }
        int reversed2 = 0;
        while (reversed1 != 0) {
            reversed2 *= 10;
            reversed2 += reversed1 % 10;
            reversed1 /= 10;
        }
        return reversed2 == originalNum;
    }
}