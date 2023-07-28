class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < piles.length; i++) {
            pq.offer(piles[i]);
        }
        while (k > 0) {
            int max = pq.poll();
            pq.offer(max - max / 2);
            k--;
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
}