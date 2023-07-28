class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int m = rolls.length;
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        int total = mean * (m + n);
        int missing = total - sum;
        if (missing < n || missing > 6 * n) {
            return new int[0];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = 1;
        }
        missing -= n;
        for (int i = 0; i < n; i++) {
            int x = Math.min(5, missing);
            ans[i] += x;
            missing -= x;
        }
        return ans;
    }
}