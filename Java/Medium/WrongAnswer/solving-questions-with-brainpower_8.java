class Solution {
    public long mostPoints(int[][] questions) {
        
        long sum = 0;
        for(int[] question : questions) {
            sum += question[0];
        }
        Arrays.sort(questions, (a, b) -> b[1] - a[1]);
        int n = questions.length;
        int[] dp = new int[n];
        dp[0] = questions[0][0];
        for(int i = 1; i < n; i++) {
            int points = questions[i][0];
            int brain = questions[i][1];
            int next = Math.max(0, i - brain - 1);
            dp[i] = Math.max(dp[i - 1], points + dp[next]);
        }
        return sum - dp[n - 1];
    }
}