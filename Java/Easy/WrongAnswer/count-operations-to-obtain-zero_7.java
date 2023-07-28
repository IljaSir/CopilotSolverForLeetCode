class Solution {
    public int countOperations(int num1, int num2) {
        
        if (num1 < num2) {
            int tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        int count = 0;
        while (num1 > 0 && num2 > 0) {
            if (num1 % 2 == 0) {
                num1 /= 2;
            } else {
                num1--;
            }
            count++;
            if (num1 < num2) {
                int tmp = num1;
                num1 = num2;
                num2 = tmp;
            }
        }
        return count;
    }
}