class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<Integer> ans = nw ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            degree[u]++;
            degree[v]++;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            ans = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                ans.add(cur);
                for (int next : graph.get(cur)) {
                    degree[next]--;
                    if (degree[next] == 1) {
                        queue.offer(next);
                    }
                }
            }
        }
        return an
            leaves = newLeaves;
        }
        return leaves;
    }
}