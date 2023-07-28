class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{servers[i], i});
        }
        for (int i = 0; i < m; i++) {
            while (!pq2.isEmpty() && pq2.peek()[2] <= i) {
                pq.offer(pq2.poll());
            }
            if (pq.isEmpty()) {
                int[] cur = pq2.poll();
                ans[i] = cur[1];
                cur[2] = i + tasks[i];
                pq2.offer(cur);
            } else {
                int[] cur = pq.poll();
                ans[i] = cur[1];
                cur[0] = tasks[i];
                cur[2] = i + tasks[i];
                pq2.offer(cur);
            }
        }
        return ans;
    }
}