class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int[] result = new int[n];
        int sum = 0;
        for (int i = 0; i < rolls.length; i++) {
            sum += rolls[i];
        }
        int total = (n + rolls.length) * mean;
        int missing = total - sum;
        if (missing < n || missing > 6 * n) {
            return new int[0];
        }
        for (int i = 0; i < n; i++) {
            int min = Math.max(1, missing - 6 * (n - i - 1));
            int max = Math.min(6, missing - n + i + 1);
            result[i] = min;
            missing -= min;
        }
        return result;
    }
}