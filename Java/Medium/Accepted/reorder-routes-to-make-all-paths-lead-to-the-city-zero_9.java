class Solution {
    public int minReorder(int n, int[][] connections) {
        
        // Create a graph
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(-connection[0]);
        }

        // BFS
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int res = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph[curr]) {
                if (visited[Math.abs(next)]) {
                    continue;
                }
                if (next > 0) {
                    res++;
                }
                queue.offer(Math.abs(next));
                visited[Math.abs(next)] = true;
            }
        }
        return res;
    }
}