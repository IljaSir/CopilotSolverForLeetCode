class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            free.add(new int[]{servers[i], i, 0});
        }
        for (int i = 0; i < m; i++) {
            while (!busy.isEmpty() && busy.peek()[2] <= i) {
                free.add(new int[]{busy.poll()[0], busy.peek()[1], 0});
            }
            if (free.isEmpty()) {
                int[] server = busy.poll();
                server[2] += tasks[i];
                busy.add(server);
                ans[i] = server[1];
            } else {
                int[] server = free.poll();
                server[2] = i + tasks[i];
                busy.add(server);
                ans[i] = server[1];
            }
        }
        return ans;
    }
}