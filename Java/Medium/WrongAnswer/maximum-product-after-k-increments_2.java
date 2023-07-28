class Solution {
    public int maximumProduct(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            int min = minHeap.poll();
            minHeap.offer(min + 1);
        }
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            res = (res * minHeap.poll()) % (int)(Math.pow(10, 9) + 7);
        }
        return res;
    }
}