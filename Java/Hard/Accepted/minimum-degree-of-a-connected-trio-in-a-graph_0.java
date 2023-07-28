class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (!graph.get(i).contains(j)) {
                    continue;
                }
                for (int k = j + 1; k <= n; k++) {
                    if (!graph.get(i).contains(k) || !graph.get(j).contains(k)) {
                        continue;
                    }
                    int degree = graph.get(i).size() + graph.get(j).size() + graph.get(k).size() - 6;
                    min = Math.min(min, degree);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}