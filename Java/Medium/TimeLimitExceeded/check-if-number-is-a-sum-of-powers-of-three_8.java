class Solution {
    public boolean checkPowersOfThree(int n) {
        
        int a = n;
        int b = 1;
        while (b < a) {
            b *= 3;
        }
        while (a > 0) {
            if (a >= b) {
                a -= b;
            }
            b /= 3;
        }
        return a == 0;
    }
}