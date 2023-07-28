class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        int total = mean * (n + rolls.length);
        int missing = total - sum;
        if (missing < n || missing > n * 6) {
            return new int[0];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1;
            missing--;
        }
        for (int i = 0; i < n; i++) {
            int increase = Math.min(5, missing);
            result[i] += increase;
            missing -= increase;
        }
        return result;
    }
}