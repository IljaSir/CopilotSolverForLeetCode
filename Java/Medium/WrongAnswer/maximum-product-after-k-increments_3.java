class Solution {
    public int maximumProduct(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.add(n);
        }
        for (int i = 0; i < k; i++) {
            int n = minHeap.poll();
            minHeap.add(n + 1);
        }
        long product = 1;
        for (int n : minHeap) {
            product *= n;
        }
        return (int) (product % (1000000000 + 7));
    }
}