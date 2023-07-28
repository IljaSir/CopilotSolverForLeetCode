class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        int[] res = new int[tasks.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
        for (int i = 0; i < servers.length; i++) {
            pq.offer(new int[] {servers[i], i, 0});
        }
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            while (!busy.isEmpty() && busy.peek()[2] <= time) {
                int[] server = busy.poll();
                pq.offer(new int[] {server[0], server[1], 0});
            }
            if (pq.isEmpty()) {
                time = busy.peek()[2];
                while (!busy.isEmpty() && busy.peek()[2] <= time) {
                    int[] server = busy.poll();
                    pq.offer(new int[] {server[0], server[1], 0});
                }
            }
            int[] server = pq.poll();
            server[2] = time + tasks[i];
            busy.offer(server);
            res[i] = server[1];
            time = Math.max(time, i + 1);
        }
        return res;
    }
}