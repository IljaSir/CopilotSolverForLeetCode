class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        int n = nums.length;
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int ans = n + 1;
        for (int i = 0; i <= n; i++) {
            while (!queue.isEmpty() && prefix[i] - prefix[queue.peekFirst()] >= k) {
                ans = Math.min(ans, i - queue.pollFirst());
            }
            while (!queue.isEmpty() && prefix[i] <= prefix[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return ans == n + 1 ? -1 : ans;
    }
}