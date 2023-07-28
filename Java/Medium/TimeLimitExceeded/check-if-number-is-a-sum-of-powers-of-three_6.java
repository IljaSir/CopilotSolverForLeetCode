class Solution {
    public boolean checkPowersOfThree(int n) {
        
        int m = 1;
        while (m <= n) {
            m *= 3;
        }
        while (n > 0) {
            m /= 3;
            if (m <= n) {
                n -= m;
            }
        }
        return n == 0;
    }
}