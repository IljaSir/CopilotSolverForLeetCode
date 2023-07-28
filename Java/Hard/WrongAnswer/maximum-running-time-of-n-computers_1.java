class Solution {
    public long maxRunTime(int n, int[] batteries) {
        
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.offer(batteries[i]);
            sum += batteries[i];
        }
        long res = sum;
        for (int i = n; i < batteries.length; i++) {
            int battery = pq.poll();
            sum -= battery;
            sum += batteries[i];
            pq.offer(batteries[i]);
            res = Math.min(res, sum);
        }
        return res;
    }
}