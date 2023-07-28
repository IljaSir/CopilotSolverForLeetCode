class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int m = rolls.length;
        int sum = Arrays.stream(rolls).sum();
        int total = mean * (n + m);
        int missing = total - sum;
        if (missing < n || missing > 6 * n) {
            return new int[0];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 1;
            missing--;
        }
        int i = 0;
        while (missing > 0) {
            if (res[i] < 6) {
                res[i]++;
                missing--;
            }
            i++;
        }
        return res;
    }
}