class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        
        int[] in = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] r : relations) {
            int a = r[0] - 1, b = r[1] - 1;
            graph[a].add(b);
            in[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }
        int res = 0;
        while (!q.isEmpty()) {
            int size = Math.min(q.size(), k);
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int next : graph[cur]) {
                    if (--in[next] == 0) {
                        q.offer(next);
                    }
                }
            }
            res++;
        }
        return res;
    }
}