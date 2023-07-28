class Solution {
    public int eatenApples(int[] apples, int[] days) {
        
        int n = apples.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0, res = 0;
        while (i < n || !pq.isEmpty()) {
            if (i < n && apples[i] > 0) {
                pq.offer(new int[]{i + days[i], apples[i]});
            }
            while (!pq.isEmpty() && (pq.peek()[0] <= i || pq.peek()[1] == 0)) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.peek()[1]--;
                res++;
            }
            i++;
        }
        return res;
    }
}