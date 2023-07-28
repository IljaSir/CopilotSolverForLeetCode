class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int m = rolls.length;
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        int total = (m + n) * mean - sum;
        if (total < n || total > 6 * n) {
            return new int[0];
        }
        int[] res = new int[n];
        int avg = total / n;
        int rem = total % n;
        for (int i = 0; i < n; i++) {
            res[i] = avg;
        }
        for (int i = 0; i < rem; i++) {
            res[i]++;
        }
        return res;
    }
}