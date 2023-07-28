class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (left.size() <= right.size()) {
                right.offer(i);
                left.offer(right.poll());
            } else {
                left.offer(i);
                right.offer(left.poll());
            }
            if (left.size() + right.size() == k) {
                if (left.size() == right.size()) {
                    result[i - k + 1] = (nums[left.peek()] + nums[right.peek()]) / 2.0;
                } else {
                    result[i - k + 1] = nums[left.peek()];
                }
                if (!left.remove(i - k + 1)) {
                    right.remove(i - k + 1);
                }
            }
        }
        return result;
    }
}