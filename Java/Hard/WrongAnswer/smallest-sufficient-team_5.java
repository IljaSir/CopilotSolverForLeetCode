class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        
        int n = req_skills.length;
        int m = people.size();
        Map<String, Integer> skillToIndex = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            skillToIndex.put(req_skills[i], i);
        }
        int[] peopleSkills = new int[m];
        for (int i = 0; i < m; ++i) {
            for (String skill : people.get(i)) {
                peopleSkills[i] |= 1 << skillToIndex.get(skill);
            }
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        int[] pre = new int[1 << n];
        Arrays.fill(pre, -1);
        for (int mask = 0; mask < (1 << n) - 1; ++mask) {
            for (int i = 0; i < m; ++i) {
                int next = mask | peopleSkills[i];
                if (dp[next] > dp[mask] + 1) {
                    dp[next] = dp[mask] + 1;
                    pre[next] = i;
                }
            }
        }
        int[] ans = new int[dp[(1 << n) - 1]];
        int t = ans.length - 1;
        int mask = (1 << n) - 1;
        while (t >= 0) {
            ans[t--] = pre[mask];
            mask ^= peopleSkills[pre[mask]];
        }
        return ans;
    }
}