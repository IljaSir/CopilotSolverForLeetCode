class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int m = rolls.length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += rolls[i];
        }
        int total = (m + n) * mean;
        int missingSum = total - sum;
        int[] result = new int[n];
        int q = missingSum / n;
        int r = missingSum % n;
        if (q > 6 || q == 0 && r > 0) {
            return new int[0];
        }
        for (int i = 0; i < n; i++) {
            if (i < r) {
                result[i] = q + 1;
            } else {
                result[i] = q;
            }
        }
        return result;
    }
}