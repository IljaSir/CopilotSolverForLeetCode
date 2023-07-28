class Solution {
    public int countOperations(int num1, int num2) {
        
        if (num1 == num2) {
            return num1 == 0 ? 0 : 1;
        }
        if (num1 > num2) {
            return countOperations(num2, num1);
        }
        int res = 0;
        while (num2 > 0) {
            res += num2 / num1;
            int tmp = num2 % num1;
            num2 = num1;
            num1 = tmp;
        }
        return res;
    }
}