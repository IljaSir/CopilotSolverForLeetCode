class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        for (int i = 0; i < servers.length; i++) {
            pq1.add(new int[]{servers[i], i});
        }
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int[] ans = new int[tasks.length];
        int time = 0;
        int i = 0;
        while (i < tasks.length) {
            while (!pq2.isEmpty() && pq2.peek()[0] <= time) {
                pq1.add(pq2.poll());
            }
            if (pq1.isEmpty()) {
                time = pq2.peek()[0];
            } else {
                int[] server = pq1.poll();
                ans[i] = server[1];
                pq2.add(new int[]{time + tasks[i], server[1]});
                i++;
            }
        }
        while (!pq2.isEmpty()) {
            int[] server = pq2.poll();
            ans[i] = server[1];
            i++;
        }
        return ans;
    }
}