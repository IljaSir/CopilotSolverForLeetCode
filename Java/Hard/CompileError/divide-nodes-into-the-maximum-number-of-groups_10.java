class Solution {
    public int magnificentSets(int n, int[][] edges) {
        
        int[] group = new int[n];
        int[] groupSize = new int[n];
        int[] groupNum = new int[n];
        int[] groupNumSize = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
            groupSize[i] = 1;
            groupNum[i] = i;
            groupNumSize[i] = 1;
        }
        for (int[] edge : edges) {
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            int groupA = find(group, a);
            int groupB = find(group, b);
            if (groupA != groupB) {
                group[groupA] = groupB;
                groupSize[groupB] += groupSize[groupA];
            }
            int groupNumA = find(groupNum, a);
            int groupNumB = find(groupNum, b);
            if (groupNumA != groupNumB) {
                groupNum[groupNumA] = groupNumB;
                groupNumSize[groupNumB] += groupNumSize[groupNumA];
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(group, i));
        }
        int result = 0;
        for (int i : set) {
            result += groupSize[i];
        }
        return result;
    }
    private int find(int[] group, int i) {
        if (group[i] != i) {
            group[i] = find(group, group[i]);
        }
        return group[i];dfs(i, adj, visited, groupCount, groups);
                groupCount++;
            }
        }
        int[] groupSize = new int[groupCount];
        for (int i = 0; i < n; i++) {
            groupSize[groups[i]]++;
        }
        int[] dp = new int[1 << groupCount];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < (1 << groupCount); i++) {
            if (dp[i] < 0) {
                continue;
            }
            for (int j = 0; j < groupCount; j++) {
                if ((i & (1 << j)) == 0) {
                    int next = i | (1 << j);
                    dp[next] = Math.max(dp[next], dp[i] + groupSize[j]);
                }
            }
        }
        return dp[(1 << groupCount) - 1];
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, int groupCount, int[] groups) {
        visited[node] = true;
        groups[node] = groupCount;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, groupCount, groups);
            }
        }
    }
}