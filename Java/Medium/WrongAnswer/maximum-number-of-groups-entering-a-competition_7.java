class Solution {
    public int maximumGroups(int[] grades) {
        
        int[] freq = new int[100001];
        for (int grade : grades) {
            freq[grade]++;
        }
        int[] dp = new int[grades.length + 1];
        for (int i = 1; i <= 100000; i++) {
            if (freq[i] == 0) {
                continue;
            }
            int[] newDp = new int[grades.length + 1];
            for (int j = 0; j <= grades.length; j++) {
                if (dp[j] == 0) {
                    continue;
                }
                int sum = 0;
                for (int k = 0; k <= freq[i] && j + k <= grades.length; k++) {
                    sum += i;
                    newDp[j + k] = Math.max(newDp[j + k], dp[j] + (sum >= (j + k) * i ? 1 : 0));
                }
            }
            dp = newDp;
        }
        int ans = 0;
        for (int i = 0; i <= grades.length; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}