class Solution {
    public int maximumTop(int[] nums, int k) {
        
        int n = nums.length;
        if (n == 1) {
            return k > 0 ? -1 : nums[0];
        }
        int ans = nums[0];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 1; i < n; i++) {
            pq.offer(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            int top = pq.poll();
            ans = Math.max(ans, top);
            top--;
            if (top > 0) {
                pq.offer(top);
            }
        }
        return ans;
    }
}