class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        int m = tasks.length;
        int n = servers.length;
        int[] ans = new int[m];
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            free.offer(new int[]{servers[i], i});
        }
        int time = 0;
        for (int i = 0; i < m; i++) {
            time = Math.max(time, i);
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                free.offer(new int[]{busy.poll()[1], busy.peek()[2]});
            }
            if (free.isEmpty()) {
                time = busy.peek()[0];
                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    free.offer(new int[]{busy.poll()[1], busy.peek()[2]});
                }
            }
            int[] cur = free.poll();
            ans[i] = cur[1];
            busy.offer(new int[]{time + tasks[i], cur[0], cur[1]});
        }
        return ans;
    }
}