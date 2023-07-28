class Solution {
    public int eatenApples(int[] apples, int[] days) {
        
        int n = apples.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int res = 0;
        for (int i = 0; i < n || !pq.isEmpty(); i++) {
            if (i < n && apples[i] > 0) {
                pq.offer(new int[]{apples[i], i + days[i] - 1});
            }
            while (!pq.isEmpty() && (pq.peek()[1] < i || pq.peek()[0] == 0)) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.peek()[0]--;
                res++;
            }
        }
        return res;
    }
}