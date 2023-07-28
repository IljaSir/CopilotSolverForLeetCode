class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        
        int n = req_skills.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(req_skills[i], i);
        }
        int m = people.size();
        int[] dp = new int[1 << n];
        int[] pre = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            int skill = 0;
            for (String s : people.get(i)) {
                skill |= 1 << map.get(s);
            }
            for (int j = 0; j < (1 << n); j++) {
                if (dp[j] + 1 < dp[j | skill]) {
                    dp[j | skill] = dp[j] + 1;
                    pre[j | skill] = i;
                }
            }
        }
        int[] ans = new int[dp[(1 << n) - 1]];
        int status = (1 << n) - 1;
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = pre[status];
            status ^= 1 << map.get(req_skills[pre[status]]);
        }
        return ans;
    }
}