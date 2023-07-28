class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], list -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], list -> new ArrayList<>()).add(edge[0]);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[]{0, 1});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currDist = curr[0];
            int currNode = curr[1];
            if (currDist > dist[currNode]) {
                continue;
            }
            for (int next : graph.getOrDefault(currNode, new ArrayList<>())) {
                int nextDist = currDist + time + getExtraTime(currDist + time, change);
                if (nextDist < dist[next]) {
                    dist[next] = nextDist;
                    queue.offer(new int[]{nextDist, next});
                }
            }
        }
        return dist[n];
    }
    
    private int getExtraTime(int time, int change) {
        int remainder = time % (2 * change);
        if (remainder < change) {
            return 0;
        }
        return 2 * change - remainder;
    }
}