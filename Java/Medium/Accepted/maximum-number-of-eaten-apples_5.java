class Solution {
    public int eatenApples(int[] apples, int[] days) {
        
        int n = apples.length;
        int sum = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            if (apples[i] > 0) {
                pq.offer(new int[]{i + days[i], apples[i]});
            }
            while (!pq.isEmpty() && (pq.peek()[0] <= i || pq.peek()[1] == 0)) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                int[] top = pq.poll();
                top[1]--;
                sum++;
                if (top[1] > 0) {
                    pq.offer(top);
                }
            }
        }
        int day = n;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int eat = Math.min(top[1], top[0] - day);
            sum += eat;
            day += eat;
        }
        return sum;
    }
}