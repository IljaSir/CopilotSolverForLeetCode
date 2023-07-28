class Solution {
    public int minReorder(int n, int[][] connections) {
        
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] c : connections) {
            graph[c[0]].add(c[1]);
            graph[c[1]].add(-c[0]);
        }
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int res = 0;
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            for (int next : graph[cur]) {
                if (next < 0) {
                    next = -next;
                } else {
                    ++res;
                }
                stack.push(next);
            }
        }
        return res;
    }
}