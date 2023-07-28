class Solution {
    public int eatenApples(int[] apples, int[] days) {
        
        int n = apples.length;
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{apples[i], i + days[i]});
            while (!pq.isEmpty() && (pq.peek()[0] == 0 || pq.peek()[1] <= i)) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                cur[0]--;
                ans++;
                if (cur[0] > 0) {
                    pq.offer(cur);
                }
            }
        }
        int i = n;
        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && (pq.peek()[0] == 0 || pq.peek()[1] <= i)) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                cur[0]--;
                ans++;
                i++;
                if (cur[0] > 0) {
                    pq.offer(cur);
                }
            }
        }
        return ans;
    }
}