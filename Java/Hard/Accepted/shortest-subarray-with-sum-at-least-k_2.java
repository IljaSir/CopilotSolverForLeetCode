class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        int n = nums.length;
        long[] p = new long[n+1];
        for (int i = 0; i < n; ++i)
            p[i+1] = p[i] + (long) nums[i];

        // Want smallest y-x with Py - Px >= k
        int ans = n+1; // n+1 is impossible
        Deque<Integer> monoq = new ArrayDeque(); //opt(y) candidates, represented as indices of P
        for (int y = 0; y < p.length; ++y) {
            // Want opt(y) = largest x with Px <= Py - k;
            while (!monoq.isEmpty() && p[y] <= p[monoq.getLast()])
                monoq.removeLast();

            while (!monoq.isEmpty() && p[y] >= p[monoq.getFirst()] + k)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < n+1 ? ans : -1;
    }
}