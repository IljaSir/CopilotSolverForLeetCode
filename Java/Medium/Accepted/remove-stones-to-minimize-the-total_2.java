class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int p : piles) {
            sum += p;
            pq.offer(p);
        }
        while (k-- > 0) {
            int p = pq.poll();
            int half = p / 2;
            sum -= half;
            pq.offer(p - half);
        }
        return sum;
    }
}