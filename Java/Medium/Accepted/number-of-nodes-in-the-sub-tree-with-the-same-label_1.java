class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] res = new int[n];
        dfs(0, -1, labels, res, graph);
        return res;
    }
    
    private int[] dfs(int cur, int pre, String labels, int[] res, List<Integer>[] graph) {
        int[] count = new int[26];
        count[labels.charAt(cur) - 'a']++;
        for (int nei : graph[cur]) {
            if (nei == pre) {
                continue;
            }
            int[] neiCount = dfs(nei, cur, labels, res, graph);
            for (int i = 0; i < 26; i++) {
                count[i] += neiCount[i];
            }
        }
        res[cur] = count[labels.charAt(cur) - 'a'];
        return count;
    }
}