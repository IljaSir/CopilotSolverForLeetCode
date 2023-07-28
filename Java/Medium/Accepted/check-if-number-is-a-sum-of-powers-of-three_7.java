class Solution {
    public boolean checkPowersOfThree(int n) {
        
        int max = (int) (Math.log(n) / Math.log(3));
        int[] powers = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            powers[i] = (int) Math.pow(3, i);
        }
        for (int i = max; i >= 0; i--) {
            if (n >= powers[i]) {
                n -= powers[i];
            }
        }
        return n == 0;
    }
}