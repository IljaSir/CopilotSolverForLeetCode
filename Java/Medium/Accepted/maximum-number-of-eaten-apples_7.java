class Solution {
    public int eatenApples(int[] apples, int[] days) {
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = apples.length;
        int ans = 0;
        int i = 0;
        while (i < n || !q.isEmpty()) {
            if (i < n && apples[i] > 0) {
                q.offer(new int[] {i + days[i], apples[i]});
            }
            while (!q.isEmpty() && q.peek()[0] <= i) {
                q.poll();
            }
            if (!q.isEmpty()) {
                int[] top = q.poll();
                ans++;
                top[1]--;
                if (top[1] > 0) {
                    q.offer(top);
                }
            }
            i++;
        }
        return ans;
    }
}