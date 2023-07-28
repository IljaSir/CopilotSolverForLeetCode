class Solution {
    public int[] getOrder(int[][] tasks) {
        
        int n = tasks.length;
        int[] ans = new int[n];
        int[][] tasksWithIndex = new int[n][3];
        for (int i = 0; i < n; i++) {
            tasksWithIndex[i][0] = tasks[i][0];
            tasksWithIndex[i][1] = tasks[i][1];
            tasksWithIndex[i][2] = i;
        }
        Arrays.sort(tasksWithIndex, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        long time = 0;
        int i = 0;
        int j = 0;
        while (i < n) {
            if (pq.isEmpty()) {
                time = Math.max(time, tasksWithIndex[i][0]);
            }
            while (i < n && tasksWithIndex[i][0] <= time) {
                pq.offer(tasksWithIndex[i]);
                i++;
            }
            int[] task = pq.poll();
            ans[j++] = task[2];
            time += task[1];
            while (i < n && pq.isEmpty() && tasksWithIndex[i][0] > time) {
                time = tasksWithIndex[i][0];
            }
        }
        while (!pq.isEmpty()) {
            int[] task = pq.poll();
            ans[j++] = task[2];
        }
        return ans;
    }
}