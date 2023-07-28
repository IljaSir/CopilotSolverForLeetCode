class Solution {
    public int magnificentSets(int n, int[][] edges) {
        
        int[] groups = new int[n + 1];
        int[] groupSize = new int[n + 1];
        int[] groupCount = new int[n + 1];
        int group = 0;
        for (int i = 1; i <= n; i++) {
            if (groups[i] == 0) {
                group++;
                groups[i] = group;
                groupSize[group] = 1;
                groupCount[group] = 1;
                dfs(groups, groupSize, groupCount, edges, i, group);
            }
        }
        int max = 0;
        for (int i = 1; i <= group; i++) {
            max = Math.max(max, groupSize[i]);
        }
        return max;
    }
    private void dfs(int[] groups, int[] groupSize, int[] groupCount, int[][] edges, int i, int group) {
        for (int[] edge : edges) {
            if (edge[0] == i) {
                if (groups[edge[1]] == 0) {
                    groups[edge[1]] = group;
                    groupSize[group]++;
                    dfs(groups, groupSize, groupCount, edges, edge[1], group);
                } else if (groups[edge[1]] != group) {
                    groupCount[groups[edge[1]]]--;
                    if (groupCount[groups[edge[1]]] == 0) {
                        groupSize[group] += groupSize[groups[edge[1]]];
                    }
                    groups[edge[1]] = group;
                    groupSize[group]++;
                    groupCount[group]++;
                    dfs(groups, groupSize, groupCount, edges, edge[1], group);
                }
            } else if (edge[1] == i) {
                if (groups[edge[0]] == 0) {
                    groups[edge[0]] = group;
                    groupSize[group]++;
                    dfs(groups, groupSize, groupCount, edges, edge[0], group);
                } else if (groups[edge[0]] != group) {
                    groupCount[groups[edge[0]]]--;
                    if (groupCount[groups[edge[0]]] == 0) {
                        groupSize[group] += groupSize[groups[edge[0]]];
                    }
                    groups[edge[0]] = group;
                    groupSize[group]++;
                    groupCount[group]++;
                    dfs(groups, groupSize, groupCount, edges,
    }
}