class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[2] == b[2]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });
        for (int i = 0; i < servers.length; i++) {
            freeServers.add(new int[] {servers[i], i});
        }
        int[] ans = new int[tasks.length];
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            while (!busyServers.isEmpty() && busyServers.peek()[2] <= time) {
                int[] server = busyServers.poll();
                freeServers.add(new int[] {server[0], server[1]});
            }
            if (!freeServers.isEmpty()) {
                int[] server = freeServers.poll();
                busyServers.add(new int[] {server[0], server[1], time + tasks[i]});
                ans[i] = server[1];
            } else {
                while (busyServers.peek()[2] <= time) {
                    int[] server = busyServers.poll();
                    freeServers.add(new int[] {server[0], server[1]});
                }
                int[] server = freeServers.poll();
                busyServers.add(new int[] {server[0], server[1], busyServers.peek()[2] + tasks[i]});
                ans[i] = server[1];
                time = busyServers.peek()[2] - 1;
            }
            time++;
        }
        return ans;
    }
}