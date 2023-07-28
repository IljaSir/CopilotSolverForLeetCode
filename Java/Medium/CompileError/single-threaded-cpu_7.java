class Solution {
    public int[] getOrder(int[][] tasks) {
        
        int n = tasks.length;
        int[] res = new int[n];
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> tasks[a][0] - tasks[b][0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (tasks[a][1] != tasks[b][1]) {
                return tasks[a][1] - tasks[b][1];
            }
            return a - b;
        });
        int i = 0, t = 0;
        int j = 0;
        while (i < n) {
            if (j < n && tasks[idx[j]][0] <= t) {
                pq.add(idx[j]);
                j++;
            } else {
                if (pq.isEmpty()) {
                    t = tasks[idx[j]][0];
                } else {
                    int cur = pq.poll();
                    res[i++] = cur;
                    t += tasks[cur][1];
                }
            }
        }
        return res;
    }
}