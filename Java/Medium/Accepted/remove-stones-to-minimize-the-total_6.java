class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            queue.offer(piles[i]);
            sum += piles[i];
        }
        while (k-- > 0) {
            int max = queue.poll();
            sum -= max / 2;
            queue.offer(max - max / 2);
        }
        return sum;
    }
}