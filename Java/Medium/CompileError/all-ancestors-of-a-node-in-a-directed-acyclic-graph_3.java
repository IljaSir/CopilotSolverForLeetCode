class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        List<List<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new ArrayList<>());
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            dfs(graph, i, ancestors);
        }
        return ancestors;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int node, List<List<Integer>> ancestors) {
        for (int neighbor : graph.get(node)) {
            ancestors.get(node).add(neighbor);
            dfs(graph, neighbor, ancestors);
            ancestors.get(node).addAll(ancestors.get(neighbor));
        }
    }
}
    }
}