class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        
        int n = passingFees.length;
        int[][] dp = new int[n][maxTime+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = passingFees[0];
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(new int[]{e[1], e[2]});
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(new int[]{e[0], e[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] e : map.getOrDefault(cur[0], Collections.emptyList())) {
                if (cur[1] + e[1] > maxTime) continue;
                if (dp[e[0]][cur[1]+e[1]] > dp[cur[0]][cur[1]] + passingFees[e[0]]) {
                    dp[e[0]][cur[1]+e[1]] = dp[cur[0]][cur[1]] + passingFees[e[0]];
                    q.add(new int[]{e[0], cur[1]+e[1]});
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= maxTime; i++) {
            res = Math.min(res, dp[n-1][i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}