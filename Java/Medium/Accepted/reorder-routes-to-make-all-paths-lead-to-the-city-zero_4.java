class Solution {
    public int minReorder(int n, int[][] connections) {
        
        int res = 0;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] c : connections) {
            graph[c[0]].add(c[1]);
            graph[c[1]].add(-c[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            for (int next : graph[cur]) {
                if (visited[Math.abs(next)]) continue;
                queue.offer(Math.abs(next));
                if (next > 0) res++;
            }
        }
        return res;
    }
}