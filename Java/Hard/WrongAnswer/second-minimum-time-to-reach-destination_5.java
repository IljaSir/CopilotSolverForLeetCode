class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == n) {
                return cur[1];
            }
            if (visited[cur[0]] < cur[1]) {
                continue;
            }
            visited[cur[0]] = cur[1];
            int cycle = cur[1] / change;
            int remain = cur[1] % change;
            int nextTime = cycle * change + change;
            for (int next : graph.getOrDefault(cur[0], new HashSet<>())) {
                if (remain > 0) {
                    queue.offer(new int[]{next, cur[1] + time + change - remain});
                }
                queue.offer(new int[]{next, nextTime + time});
            }
        }
        return -1;
    }
}