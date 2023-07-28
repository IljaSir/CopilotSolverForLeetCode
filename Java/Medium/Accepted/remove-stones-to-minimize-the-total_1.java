class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int pile : piles) {
            maxHeap.offer(pile);
        }
        while (k > 0) {
            int max = maxHeap.poll();
            maxHeap.offer(max - max / 2);
            k--;
        }
        int res = 0;
        while (!maxHeap.isEmpty()) {
            res += maxHeap.poll();
        }
        return res;
    }
}