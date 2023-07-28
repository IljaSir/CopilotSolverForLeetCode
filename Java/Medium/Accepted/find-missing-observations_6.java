class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int m = rolls.length;
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        int expectedSum = (m + n) * mean - sum;
        if (expectedSum < n || expectedSum > 6 * n) {
            return new int[0];
        }
        int[] missing = new int[n];
        int q = expectedSum / n, r = expectedSum % n;
        for (int i = 0; i < n; i++) {
            missing[i] = q + (i < r ? 1 : 0);
        }
        return missing;
    }
}