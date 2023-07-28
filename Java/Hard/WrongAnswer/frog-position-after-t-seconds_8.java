class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        
        int[] parents = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            parents[v] = u;
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        double[] prob = new double[n + 1];
        prob[1] = 1;
        for (int i = 0; i < t; ++i) {
            double[] next = new double[n + 1];
            for (int j = 1; j <= n; ++j) {
                if (prob[j] > 0) {
                    int count = 0;
                    for (int[] edge : edges) {
                        if (edge[0] == j && !visited.contains(edge[1])) {
                            ++count;
                        }
                        if (edge[1] == j && !visited.contains(edge[0])) {
                            ++count;
                        }
                    }
                    if (count == 0) {
                        next[j] = prob[j];
                    } else {
                        for (int[] edge : edges) {
                            if (edge[0] == j && !visited.contains(edge[1])) {
                                next[edge[1]] += prob[j] / count;
                            }
                            if (edge[1] == j && !visited.contains(edge[0])) {
                                next[edge[0]] += prob[j] / count;
                            }
                        }
                    }
                }
            }
            prob = next;
            visited.add(target);
            if (prob[target] > 0) {
                return prob[target];
            }
        }
        return prob[target];
    }
}