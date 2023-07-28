class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        int result = Integer.MAX_VALUE;
        int minTime = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int vertex = node[0];
            int timeElapsed = node[1];
            if (vertex == n) {
                if (minTime == Integer.MAX_VALUE) {
                    minTime = timeElapsed;
                } else {
                    result = Math.min(result, timeElapsed);
                }
            }
            visited[vertex] = true;
            for (int next : graph.getOrDefault(vertex, Collections.emptyList())) {
                if (visited[next]) {
                    continue;
                }
                int nextTimeElapsed = timeElapsed + time;
                int cycle = nextTimeElapsed / change;
                if (cycle % 2 == 1) {
                    nextTimeElapsed += change - nextTimeElapsed % change;
                }
                queue.offer(new int[]{next, nextTimeElapsed});
            }
        }
        return result;
    }
}