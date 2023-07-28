class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        // 1. build graph
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        // 2. find leaf nodes
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph[i].size() == 1) {
                leaves.add(i);
            }
        }
        // 3. remove leaves
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int neighbor = graph[leaf].get(0);
                graph[neighbor].remove(Integer.valueOf(leaf));
                if (graph[neighbor].size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}