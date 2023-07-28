class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.size() == minHeap.size()) {
                if (maxHeap.size() == 0 || nums[i] <= maxHeap.peek()) {
                    maxHeap.offer(nums[i]);
                } else {
                    minHeap.offer(nums[i]);
                    maxHeap.offer(minHeap.poll());
                }
            } else {
                if (nums[i] < maxHeap.peek()) {
                    maxHeap.offer(nums[i]);
                    minHeap.offer(maxHeap.poll());
                } else {
                    minHeap.offer(nums[i]);
                }
            }
            if (i >= k - 1) {
                if (maxHeap.size() == minHeap.size()) {
                    result[i - k + 1] = (maxHeap.peek() + minHeap.peek()) / 2.0;
                } else {
                    result[i - k + 1] = maxHeap.peek();
                }
                if (nums[i - k + 1] <= maxHeap.peek()) {
                    maxHeap.remove(nums[i - k + 1]);
                    if (maxHeap.size() < minHeap.size()) {
                        maxHeap.offer(minHeap.poll());
                    }
                } else {
                    minHeap.remove(nums[i - k + 1]);
                    if (maxHeap.size() > minHeap.size() + 1) {
                        minHeap.offer(maxHeap.poll());
                    }
                }
            }
        }
        return result;
    }
}