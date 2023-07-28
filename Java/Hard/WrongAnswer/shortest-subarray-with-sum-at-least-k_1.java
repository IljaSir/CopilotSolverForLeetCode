class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        int N = nums.length;
        int[] P = new int[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + nums[i];

        // Want smallest y-x with Py - Px >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, represented as indices of P

        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + k)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }
}