class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        
        int n = req_skills.length;
        int m = people.size();
        int[] dp = new int[1 << n];
        int[] pre = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for(int i = 0; i < m; i++){
            int mask = 0;
            for(String skill : people.get(i)){
                for(int j = 0; j < n; j++){
                    if(skill.equals(req_skills[j])){
                        mask |= (1 << j);
                        break;
                    }
                }
            }
            for(int j = 0; j < (1 << n); j++){
                if(dp[j] + 1 < dp[j | mask]){
                    dp[j | mask] = dp[j] + 1;
                    pre[j | mask] = i;
                }
            }
        }
        int mask = (1 << n) - 1;
        int[] res = new int[dp[mask]];
        int index = 0;
        while(mask > 0){
            res[index++] = pre[mask];
            mask &= ~(1 << pre[mask]);
        }
        return res;
    }
}