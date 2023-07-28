class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        double[] ans = new double[n-k+1];
        PriorityQueue<Integer> lo = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> hi = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            if (lo.size() <= hi.size()) {
                hi.add(nums[i]);
                lo.add(hi.poll());
            } else {
                lo.add(nums[i]);
                hi.add(lo.poll());
            }
            if (i >= k-1) {
                ans[i-k+1] = (lo.size() == hi.size()) ? (lo.peek()+hi.peek())/2.0 : lo.peek();
                if (!lo.remove(nums[i-k+1])) {
                    hi.remove(nums[i-k+1]);
                }
            }
        }
        return ans;
    }
}