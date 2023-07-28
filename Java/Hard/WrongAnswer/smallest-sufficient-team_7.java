class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        
        int n = req_skills.length, m = people.size();
        Map<String, Integer> skill2idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skill2idx.put(req_skills[i], i);
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, m + 1);
        dp[0] = 0;
        int[] prev = new int[1 << n];
        for (int i = 0; i < m; i++) {
            int skill = 0;
            for (String s : people.get(i)) {
                skill |= 1 << skill2idx.get(s);
            }
            for (int j = (1 << n) - 1; j >= 0; j--) {
                if (dp[j] > m) {
                    continue;
                }
                int nxt = j | skill;
                if (dp[nxt] > dp[j] + 1) {
                    dp[nxt] = dp[j] + 1;
                    prev[nxt] = j;
                }
            }
        }
        int[] ans = new int[dp[(1 << n) - 1]];
        int idx = ans.length - 1;
        int state = (1 << n) - 1;
        while (state > 0) {
            int last = state - prev[state];
            for (int i = 0; i < m; i++) {
                int skill = 0;
                for (String s : people.get(i)) {
                    skill |= 1 << skill2idx.get(s);
                }
                if (skill == last) {
                    ans[idx--] = i;
                    break;
                }
            }
            state = prev[state];
        }
        return ans;
    }
}