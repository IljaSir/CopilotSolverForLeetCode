class Solution {
    public int eatenApples(int[] apples, int[] days) {
        
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int res = 0;
        for (int i = 0; i < apples.length || !q.isEmpty(); i++) {
            if (i < apples.length && apples[i] > 0) {
                q.offer(new int[]{i + days[i], apples[i]});
            }
            while (!q.isEmpty() && (q.peek()[0] <= i || q.peek()[1] == 0)) {
                q.poll();
            }
            if (!q.isEmpty()) {
                res++;
                q.peek()[1]--;
            }
        }
        return res;
    }
}