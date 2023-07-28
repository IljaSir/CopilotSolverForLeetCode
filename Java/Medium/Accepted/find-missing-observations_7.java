class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int m = rolls.length;
        int total = 0;
        for (int i = 0; i < m; i++) {
            total += rolls[i];
        }
        int target = (mean * (m + n)) - total;
        if (target < n || target > 6 * n) {
            return new int[0];
        }
        int[] res = new int[n];
        int avg = target / n;
        int rem = target % n;
        for (int i = 0; i < n; i++) {
            res[i] = avg;
        }
        for (int i = 0; i < rem; i++) {
            res[i]++;
        }
        return res;
    }
}