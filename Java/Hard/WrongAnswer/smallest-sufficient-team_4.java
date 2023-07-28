class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        
        int n = req_skills.length;
        int m = people.size();
        int[] req = new int[n];
        for (int i = 0; i < n; i++) {
            req[i] = 1 << i;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(req_skills[i], 1 << i);
        }
        int[] dp = new int[1 << n];
        int[] pre = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            int mask = 0;
            for (String skill : people.get(i)) {
                mask |= map.get(skill);
            }
            for (int j = 0; j < (1 << n); j++) {
                if (dp[j] + 1 < dp[j | mask]) {
                    dp[j | mask] = dp[j] + 1;
                    pre[j | mask] = i;
                }
            }
        }
        int[] ans = new int[dp[(1 << n) - 1]];
        int cur = (1 << n) - 1;
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = pre[cur];
            cur ^= 1 << pre[cur];
        }
        return ans;
    }
}