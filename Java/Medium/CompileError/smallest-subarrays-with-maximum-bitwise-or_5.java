class Solution {
    public int[] smallestSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, n);
        int[] stack = new int[n];
        int top = -1;
        for (int i = n - 1; i >= 0; i--) {
            int cur = nums[i];
            while (top >= 0 && (cur | nums[stck[top]]) > cur) {
                cur |= nums[stack[top]];
                re[i] = Mah.minres[], res[stack[top]] + 1;
                top--;
            }
            stack[++top] = i
            if (!monoq.isEmpty()) {
                res[i] = Math.min(res[i], i - monoq.peekLast());
            }
            monoq.addLast(i);
        }
        monoq.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!monoq.isEmpty() && (nums[i] | nums[monoq.peekLast()]) == nums[monoq.peekLast()]) {
                monoq.pollLast();
            }
            if (!monoq.isEmpty()) {
                res[i] = Math.min(res[i], monoq.peekLast() - i);
            }
            monoq.addLast(i);
        }
        return res;
    }
}