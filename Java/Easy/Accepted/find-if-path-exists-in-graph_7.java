class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        if (source == destination) {
            return true;
        }
        int[] visited = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : map.get(cur)) {
                if (next == destination) {
                    return true;
                }
                if (visited[next] == 0) {
                    visited[next] = 1;
                    q.add(next);
                }
            }
        }
        return false;
    }
}