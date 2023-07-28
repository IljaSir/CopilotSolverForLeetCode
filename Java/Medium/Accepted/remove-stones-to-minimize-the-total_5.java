class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int total = 0;
        for (int i = 0; i < piles.length; i++) {
            total += piles[i];
            pq.add(piles[i]);
        }
        for (int i = 0; i < k; i++) {
            int max = pq.poll();
            int newMax = max - (max / 2);
            total -= (max - newMax);
            pq.add(newMax);
        }
        return total;
    }
}