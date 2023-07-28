class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        
        int n = req_skills.length;
        int m = people.size();
        int[] dp = new int[1 << n];
        int[] pre = new int[1 << n];
        int[] skill = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            for (String s : people.get(i)) {
                for (int j = 0; j < n; j++) {
                    if (s.equals(req_skills[j])) {
                        skill[i] |= (1 << j);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = (1 << n) - 1; j >= 0; j--) {
                if (dp[j] != Integer.MAX_VALUE && dp[j | skill[i]] > dp[j] + 1) {
                    dp[j | skill[i]] = dp[j] + 1;
                    pre[j | skill[i]] = i;
                }
            }
        }
        int[] ans = new int[dp[(1 << n) - 1]];
        int now = (1 << n) - 1;
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = pre[now];
            now -= skill[pre[now]];
        }
        return ans;
    }
}