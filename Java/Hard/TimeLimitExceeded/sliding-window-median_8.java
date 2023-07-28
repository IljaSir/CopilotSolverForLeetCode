class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int l = 0, r = 0;
        while (r < nums.length) {
            maxHeap.offer(nums[r]);
            minHeap.offer(maxHeap.poll());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            if (r - l + 1 == k) {
                if (k % 2 == 0) {
                    result[l] = ((double)maxHeap.peek() + minHeap.peek()) / 2;
                } else {
                    result[l] = maxHeap.peek();
                }
                if (!maxHeap.remove(nums[l])) {
                    minHeap.remove(nums[l]);
                }
                l++;
            }
            r++;
        }
        return result;
    }
}