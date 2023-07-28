class Solution {
    public int maximumInvitations(int[] favorite) {
        
        int n = favorite.length;
        List<Integer> [] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int j = favorite[i];
            if (j != i) {
                graph[i].add(j);
            }
        }
        int[] color = new int[n];
        int[] match = new int[n];
        Arrays.fill(match, -1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                res += dfs(i, graph, color, match);
            }
        }
        return res;
    }
    private int dfs(int i, List<Integer>[] graph, int[] color, int[] match) {
        color[i] = 1;
        for (int j : graph[i]) {
            if (match[j] == -1 || color[match[j]] == 0 && dfs(match[j], graph, color, match) == 1) {
                match[j] = i;
                return 1;
            }
        }
        return 0;
    }
}