class Solution {
    public long minimumMoney(int[][] transactions) {
        
        long res = 0, sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] t : transactions) {
            pq.offer(t[0] - t[1]);
            sum += t[0];
            while (sum < 0) {
                sum += pq.poll();
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}