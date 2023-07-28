class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        int[] indegree = new int[n];
        int[] dp = new int[n];
        for(int[] r : relations){
            indegree[r[1]-1]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.offer(i);
                dp[i] = time[i];
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int[] r : relations){
                if(r[0] == cur + 1){
                    int next = r[1] - 1;
                    dp[next] = Math.max(dp[next], dp[cur] + time[next]);
                    indegree[next]--;
                    if(indegree[next] == 0){
                        q.offer(next);
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}