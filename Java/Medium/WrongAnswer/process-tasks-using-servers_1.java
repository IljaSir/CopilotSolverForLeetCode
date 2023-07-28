class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        int[] ans = new int[tasks.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < servers.length; i++) {
            free.offer(new int[]{servers[i], i});
        }
        int j = 0;
        int t = 0;
        while (j < tasks.length) {
            while (!pq.isEmpty() && pq.peek()[2] <= t) {
                free.offer(pq.poll());
            }
            if (free.isEmpty()) {
                t = pq.peek()[2];
                continue;
            }
            while (j < tasks.length && j <= t) {
                int[] server = free.poll();
                ans[j] = server[1];
                pq.offer(new int[]{server[0], server[1], t + tasks[j]});
                j++;
            }
            t++;
        }
        return ans;
    }
}