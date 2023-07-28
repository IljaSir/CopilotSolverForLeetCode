class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        int[] inDegree = new int[n];
        int[] dp = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] relation : relations) {
            int prev = relation[0] - 1;
            int next = relation[1] - 1;
            graph.get(prev).add(next);
            inDegree[next]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        int ans = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            ans = Math.max(ans, dp[cur] + time[cur]);
            for(int next : graph.get(cur)) {
                inDegree[next]--;
                dp[next] = Math.max(dp[next], dp[cur] + time[cur]);
                if(inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        return ans;
    }
}