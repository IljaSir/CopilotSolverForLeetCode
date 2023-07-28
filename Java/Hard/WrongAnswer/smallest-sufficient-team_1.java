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
                peopleSkills[i] |= (1 << skillToIndex.get(skill));
            }
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        int[] parent = new int[1 << n];
        for (int i = 0; i < m; i++) {
            for (int j = (1 << n) - 1; j >= 0; j--) {
                int nj = j | peopleSkills[i];
                if (dp[nj] > dp[j] + 1) {
                    dp[nj] = dp[j] + 1;
                    parent[nj] = j;
                }
            }
        }
        int[] ans = new int[dp[(1 << n) - 1]];
        int cur = (1 << n) - 1;
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = Integer.numberOfTrailingZeros(cur ^ parent[cur]);
            cur = parent[cur];
        }
        return ans;
    }
}