class Solution {
    public boolean checkPowersOfThree(int n) {
        
        int[] powers = new int[15];
        powers[0] = 1;
        for (int i = 1; i < 15; i++) {
            powers[i] = powers[i - 1] * 3;
        }
        for (int i = 14; i >= 0; i--) {
            if (n >= powers[i]) {
                n -= powers[i];
            }
        }
        return n == 0;
    }
}