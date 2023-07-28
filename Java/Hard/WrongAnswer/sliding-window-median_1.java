class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                if (nums[i - k] <= maxHeap.peek()) {
                    maxHeap.remove(nums[i - k]);
                } else {
                    minHeap.remove(nums[i - k]);
                }
            }
            if (maxHeap.isEmpty() || nums[i] <= maxHeap.peek()) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.size() == minHeap.size() ? (maxHeap.peek() + minHeap.peek()) / 2.0 : maxHeap.peek();
            }
        }
        return result;
    }
}