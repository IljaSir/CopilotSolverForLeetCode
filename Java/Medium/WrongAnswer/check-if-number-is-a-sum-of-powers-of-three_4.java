class Solution {
    public boolean checkPowersOfThree(int n) {
        
        for (int i = 15; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                n -= Math.pow(3, i);
            }
        }
        return n == 0;
    }
}