class Solution {
    public int minJumps(int[] arr) {
        
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }
        // 1. build the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        // 2. bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == n - 1) {
                    return steps;
                }
                // 1. next index
                if (cur + 1 < n && !visited[cur + 1]) {
                    queue.offer(cur + 1);
                    visited[cur + 1] = true;
                }
                // 2. prev index
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    queue.offer(cur - 1);
                    visited[cur - 1] = true;
                }
                // 3. same value index
                for (int next : graph.get(arr[cur])) {
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
                graph.get(arr[cur]).clear();
            }
            steps++;
        }
        return -1;
    }
}