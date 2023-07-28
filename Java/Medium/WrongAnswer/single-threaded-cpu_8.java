class Solution {
    public int[] getOrder(int[][] tasks) {
        
        int n = tasks.length;
        int[][] taskWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            taskWithIndex[i][0] = tasks[i][0];
            taskWithIndex[i][1] = i;
        }
        Arrays.sort(taskWithIndex, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]));
        int[] ans = new int[n];
        int i = 0, t = 0;
        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty() && i < n) {
                t = Math.max(t, taskWithIndex[i][0]);
            }
            while (i < n && t >= taskWithIndex[i][0]) {
                pq.offer(new int[]{taskWithIndex[i][0], tasks[taskWithIndex[i][1]][1], taskWithIndex[i][1]});
                i++;
            }
            int[] task = pq.poll();
            t += task[1];
            ans[i++] = task[2];
        }
        return ans;
    }
}