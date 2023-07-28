class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        
        int n = quiet.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[n];
        for (int[] r : richer) {
            graph[r[1]].add(r[0]);
            indegree[r[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int[] result = new int[n];
        while (!q.isEmpty()) {
            int cur = q.poll();
            result[cur] = cur;
            for (int next : graph[cur]) {
                if (quiet[result[cur]] < quiet[result[next]]) {
                    result[next] = result[cur];
                }
                if (--indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return result;
    }
}