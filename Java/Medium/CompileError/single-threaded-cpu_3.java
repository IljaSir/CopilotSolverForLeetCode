class Solution {
    public int[] getOrder(int[][] tasks) {
        
        int n = tasks.length;
        int[] res = new int[n];
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> tasks[a][0] - tasks[b][0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (tasks[a][1] != tasks[b][1]) {
                return tasks[a][1] - tasks[b][1];
            }
            return a - b;
        });
        int t = 0;
        int i = 0;
        int j = 0;
        while (i < n) {
            while (j < n && tasks[index[j]][0] <= t) {
                pq.offer(index[j++]);
            }
            if (pq.isEmpty()) {
                t = tasks[index[j]][0];
            } else {
                int cur = pq.poll();
                res[i++] = cur;
                t += tasks[cur][1];
            }
        }
        return res;
    }
}