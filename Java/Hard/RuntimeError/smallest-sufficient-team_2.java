class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        
        int n = req_skills.length;
        Map<String, Integer> skillToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillToIndex.put(req_skills[i], i);
        }
        int m = people.size();
        int[] peopleSkills = new int[m];
        for (int i = 0; i < m; i++) {
            for (String skill : people.get(i)) {
                peopleSkills[i] |= 1 << skillToIndex.get(skill);
            }
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        int[] prev = new int[1 << n];
        Arrays.fill(prev, -1);
        for (int i = 0; i < m; i++) {
            for (int j = (1 << n) - 1; j >= 0; j--) {
                if (dp[j] + 1 < dp[j | peopleSkills[i]]) {
                    dp[j | peopleSkills[i]] = dp[j] + 1;
                    prev[j | peopleSkills[i]] = i;
                }
            }
        }
        int[] ans = new int[dp[(1 << n) - 1]];
        int state = (1 << n) - 1;
        int index = ans.length - 1;
        while (state != 0) {
            ans[index--] = prev[state];
            state = state & ~(1 << prev[state]);
        }
        return ans;
    }
}