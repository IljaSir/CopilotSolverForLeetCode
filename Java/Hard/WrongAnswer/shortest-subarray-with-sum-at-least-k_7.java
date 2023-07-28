class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int ans = n + 1;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i <= n; ++i) {
            while (!deque.isEmpty() && prefix[i] <= prefix[deque.getLast()]) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && prefix[i] >= prefix[deque.getFirst()] + k) {
                ans = Math.min(ans, i - deque.removeFirst());
            }
            deque.addLast(i);
        }
        return ans == n + 1 ? -1 : ans;
    }
}