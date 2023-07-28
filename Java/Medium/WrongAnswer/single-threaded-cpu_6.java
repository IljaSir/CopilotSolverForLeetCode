class Solution {
    public int[] getOrder(int[][] tasks) {
        
        int n = tasks.length;
        int[] ans = new int[n];
        int[][] newTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            newTasks[i][0] = tasks[i][0];
            newTasks[i][1] = tasks[i][1];
            newTasks[i][2] = i;
        }
        Arrays.sort(newTasks, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o1[2] - o2[2];
            }
        });
        int index = 0;
        int time = 0;
        while (index < n) {
            while (index < n && newTasks[index][0] <= time) {
                pq.offer(newTasks[index++]);
            }
            if (pq.isEmpty()) {
                pq.offer(newTasks[index++]);
            }
            int[] task = pq.poll();
            ans[task[2]] = time;
            time += task[1];
        }
        while (!pq.isEmpty()) {
            int[] task = pq.poll();
            ans[task[2]] = time;
            time += task[1];
        }
        return ans;
    }
}