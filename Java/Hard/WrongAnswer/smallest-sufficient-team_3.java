class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        
        int n = req_skills.length;
        Map<String, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillMap.put(req_skills[i], i);
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int[] pre = new int[1 << n];
        Arrays.fill(pre, -1);
        for (int i = 0; i < people.size(); i++) {
            List<String> skills = people.get(i);
            int skill = 0;
            for (String s : skills) {
                skill |= 1 << skillMap.get(s);
            }
            for (int j = (1 << n) - 1; j >= 0; j--) {
                if (dp[j] != Integer.MAX_VALUE && dp[j | skill] > dp[j] + 1) {
                    dp[j | skill] = dp[j] + 1;
                    pre[j | skill] = i;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        int state = (1 << n) - 1;
        while (state != 0) {
            ans.add(pre[state]);
            state = state & ~(1 << pre[state]);
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}