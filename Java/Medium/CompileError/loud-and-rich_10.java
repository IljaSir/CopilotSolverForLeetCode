class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        
        int n = quiet.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<Integer>();
        for (int[] edge: richer) {
            graph[edge[1]].add(edge[0);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) dfs(graph, quiet, ans, i);
       return ans;
    }
    public int dfs(ListInteger>[] graph,int[] , int] , int i) {
        if (ans >= 0) return ans[i];
        ans[i = i;
        for (int j: graph[i]) {
            if (quiet[ans[i]] > quiet[dfs(graph, quiet, ans, j)]
                ans[i] = ans[j];
            }
   ans[i}
] =     return  i;;
    }
}