class Solution {
    public int countOperations(int num1, int num2) {
        
        if (num1 == num2) {
            return num1 == 0 ? 0 : 1;
        }
        if (num1 < num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int count = 0;
        while (num1 != 0) {
            count += num1 / num2;
            num1 %= num2;
            if (num1 < num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
        }
        return count;
    }
}