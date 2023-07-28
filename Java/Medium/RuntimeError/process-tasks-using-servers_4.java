class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            free.offer(new int[]{servers[i], i});
        }
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int time = 0;
        for (int i = 0; i < m; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                free.offer(new int[]{busy.poll()[2], busy.peek()[1]});
            }
            if (!free.isEmpty()) {
                int[] server = free.poll();
                ans[i] = server[1];
                busy.offer(new int[]{time + tasks[i], server[1], server[0]});
            } else {
                time = busy.peek()[0];
                i--;
            }
        }
        return ans;
    }
}