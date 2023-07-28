class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];
        // <time, index>
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        // <weight, index>
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        for (int i = 0; i < n; i++) {
            free.add(new int[] {servers[i], i});
        }
        int time = 0;
        int i = 0;
        while (i < m) {
            while (!queue.isEmpty() && queue.peek()[0] <= time) {
                int[] server = queue.poll();
                free.add(new int[] {servers[server[1]], server[1]});
            }
            if (free.isEmpty()) {
                time = queue.peek()[0];
                while (!queue.isEmpty() && queue.peek()[0] <= time) {
                    int[] server = queue.poll();
                    free.add(new int[] {servers[server[1]], server[1]});
                }
            }
            while (i < m && i <= time) {
                int[] server = free.poll();
                ans[i] = server[1];
                queue.add(new int[] {time + tasks[i], server[1]});
                i++;
            }
            time++;
        }
        return ans;
    }
}