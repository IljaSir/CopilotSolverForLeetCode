class Solution {
    public int eatenApples(int[] apples, int[] days) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int n = apples.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (apples[i] > 0) {
                pq.add(new int[] {apples[i], i + days[i] - 1});
            }
            while (!pq.isEmpty() && (i > pq.peek()[1] || pq.peek()[0] == 0)) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                cur[0]--;
                ans++;
                if (cur[0] > 0) {
                    pq.add(cur);
                }
            }
        }
        int day = n;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] >= day) {
                ans += Math.min(cur[0], cur[1] - day + 1);
            }
            day = cur[1] + 1;
        }
        return ans;
    }
}