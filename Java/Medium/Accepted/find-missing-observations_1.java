class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int m = rolls.length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += rolls[i];
        }
        int target = (m + n) * mean - sum;
        if (target < n || target > 6 * n) {
            return new int[0];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = 1;
            target--;
        }
        for (int i = n - 1; i >= 0; i--) {
            while (target > 0 && ans[i] < 6) {
                ans[i]++;
                target--;
            }
        }
        return ans;
    }
}