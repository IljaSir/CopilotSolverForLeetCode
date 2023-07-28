class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        int n = servers.length;
        int m = tasks.length;
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            free.add(new int[] {servers[i], i});
        }
        int[] ans = new int[m];
        int time = 0;
        for (int i = 0; i < m; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                free.add(new int[] {busy.poll()[2], busy.peek()[1]});
            }
            if (free.isEmpty()) {
                time = busy.peek()[0];
                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    free.add(new int[] {busy.poll()[2], busy.peek()[1]});
                }
            }
            int[] cur = free.poll();
            busy.add(new int[] {time + tasks[i], cur[1], cur[0]});
            ans[i] = cur[1];
            time = Math.max(time, i);
        }
        return ans;
    }
}