class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        int index = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (maxHeap.size() == minHeap.size()) {
                if (minHeap.isEmpty() || nums[i] <= minHeap.peek()) {
                    maxHeap.offer(nums[i]);
                } else {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(nums[i]);
                }
            } else {
                if (nums[i] > maxHeap.peek()) {
                    minHeap.offer(nums[i]);
                } else {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(nums[i]);
                }
            }
            if (i >= k - 1) {
                if (maxHeap.size() == minHeap.size()) {
                    ans[index++] = (double) (maxHeap.peek() + minHeap.peek()) / 2;
                } else {
                    ans[index++] = (double) maxHeap.peek();
                }
                if (!maxHeap.remove(nums[i - k + 1])) {
                    minHeap.remove(nums[i - k + 1]);
                }
            }
        }
        return ans;
    }
}