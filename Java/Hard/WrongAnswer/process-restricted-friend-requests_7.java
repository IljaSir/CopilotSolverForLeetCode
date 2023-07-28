class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        
        boolean[] result = new boolean[requests.length];
        boolean[] visited = new boolean[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] res : restrictions) {
            map.get(res[0]).add(res[1]);
            map.get(res[1]).add(res[0]);
        }
        for (int i = 0; i < requests.length; i++) {
            result[i] = check(requests[i][0], requests[i][1], map, visited);
        }
        return result;
    }

    private boolean check(int u, int v, Map<Integer, Set<Integer>> map, boolean[] visited) {
        if (map.get(u).contains(v)) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        visited[u] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == v) {
                return false;
            }
            for (int next : map.get(cur)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        return true;
    }
}