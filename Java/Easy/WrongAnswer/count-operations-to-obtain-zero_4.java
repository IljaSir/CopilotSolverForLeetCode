class Solution {
    public int countOperations(int num1, int num2) {
        
        if (num1 > num2) {
            int tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        if (num1 == 0) {
            return 0;
        }
        int count = 0;
        while (num1 > 0) {
            count += num2 / num1;
            num2 %= num1;
            int tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        return count - 1;
    }
}