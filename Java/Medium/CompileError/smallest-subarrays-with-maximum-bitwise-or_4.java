class Solution {
    public int[] smallestSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, n);
        Deque<Integer> monoq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!monoq.isEmpty() && (nums[i] | nums[monoq.peekLast()]) == nums[monoq.peekLast()]) {
                monoq.pollLast();
            }ast(i);
        }
        return res;
    }
}