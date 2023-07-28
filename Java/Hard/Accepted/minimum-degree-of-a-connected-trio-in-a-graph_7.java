class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        
        int[] degrees = new int[n + 1];
        Set<Integer>[] graph = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j : graph[i]) {
                for (int k : graph[i]) {
                    if (j != k && graph[j].contains(k)) {
                        res = Math.min(res, degrees[i] + degrees[j] + degrees[k] - 6);
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}