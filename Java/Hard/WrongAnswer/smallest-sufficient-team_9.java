class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        
        int[] dp = new int[1 << req_skills.length];
        int[] pre = new int[1 << req_skills.length];
        int[] skillMap = new int[req_skills.length];
        for (int i = 0; i < req_skills.length; i++) {
            skillMap[i] = 1 << i;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
            map.put(req_skills[i], i);
        }
        for (int i = 0; i < people.size(); i++) {
            int skill = 0;
            for (String s : people.get(i)) {
                skill |= 1 << map.get(s);
            }
            for (int j = 0; j < (1 << req_skills.length); j++) {
                if (dp[j] > 0 || j == 0) {
                    int state = j | skill;
                    if (dp[state] == 0 || dp[state] > dp[j] + 1) {
                        dp[state] = dp[j] + 1;
                        pre[state] = j;
                    }
                }
            }
        }
        int state = (1 << req_skills.length) - 1;
        int[] res = new int[dp[state]];
        int k = 0;
        while (state > 0) {
            int nextState = pre[state];
            int diff = state ^ nextState;
            for (int i = 0; i < req_skills.length; i++) {
                if ((diff & skillMap[i]) > 0) {
                    res[k++] = i;
                    break;
                }
            }
            state = nextState;
        }
        return res;
    }
}