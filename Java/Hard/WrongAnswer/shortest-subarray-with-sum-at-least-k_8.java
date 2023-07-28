class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        int n = nums.length;
        int[] prefixSum = new int[n+1];
        for (int i=0; i<n; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        int minLen = n+1;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i=0; i<prefixSum.length; i++) {
            while (!q.isEmpty() && prefixSum[i] - prefixSum[q.peekFirst()] >= k) {
                minLen = Math.min(minLen, i - q.pollFirst());
            }
            while (!q.isEmpty() && prefixSum[i] <= prefixSum[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        return minLen == n+1 ? -1 : minLen;
    }
}