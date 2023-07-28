class Solution {
    public int countOperations(int num1, int num2) {
        
        if (num1 == num2) {
            return num1 == 0 ? 0 : 1;
        }
        if (num1 > num2) {
            int t = num1;
            num1 = num2;
            num2 = t;
        }
        int c = 0;
        while (num1 > 0) {
            int t = num2 / num1;
            c += t;
            num2 -= t * num1;
            t = num1;
            num1 = num2;
            num2 = t;
        }
        return c;
    }
}