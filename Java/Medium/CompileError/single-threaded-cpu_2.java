class Solution {
    public int[] getOrder(int[][] tasks) {
        
        int n = tasks.length;
        int[][] t = new int[n][3];
        for (int i = 0; i < n; i++) {
            t[i][0] = tasks[i][0];
            t[i][1] = tasks[i][1];
            t[i][2] = i;
        }
        Arrays.sort(t, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]).thenComparingInt(a -> a[2]));
        int[] ans = new int[n];
        int i = 0;
        int time = t[0][0];
        int j = 0;
        while (i < n) {
            while (j < n && t[j][0] <= time) {
                pq.offer(t[j]);
                j++;
            }
            if (pq.isEmpty()) {
                time = t[j][0];
                continue;
            }
            int[] task = pq.poll();
            ans[i] = task[2];
            time += task[1];
            i++;
        }
        return ans;
    }
}