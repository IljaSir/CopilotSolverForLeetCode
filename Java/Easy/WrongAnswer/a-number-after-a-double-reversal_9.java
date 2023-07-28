class Solution {
    public boolean isSameAfterReversals(int num) {
        
        int reversed1 = 0;
        int reversed2 = 0;
        int reversed1Copy = 0;
        int reversed2Copy = 0;
        int i = 0;
        int j = 0;
        while (num > 0) {
            reversed1 = reversed1 * 10 + num % 10;
            num /= 10;
        }
        reversed1Copy = reversed1;
        while (reversed1 > 0) {
            reversed2 = reversed2 * 10 + reversed1 % 10;
            reversed1 /= 10;
        }
        while (reversed1Copy > 0) {
            i++;
            reversed1Copy /= 10;
        }
        while (reversed2 > 0) {
            j++;
            reversed2 /= 10;
        }
        while (i > j) {
            reversed2 *= 10;
            j++;
        }
        return reversed2 == num;
    }
}