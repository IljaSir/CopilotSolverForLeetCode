class Solution {
    public int[] smallestSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];
        int[] max = new int[n];
        int[] min = new int[n];
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            max[i] = nums[i];
            min[i] = nums[i];
            res[i] = 1;
            while (top >= 0 && nums[i] >= nums[stack[top]]) {
                max[i] = Math.max(max[i], max[stack[top]]);
                min[i] = Math.min(min[i], min[stack[top]]);
                res[i] += res[stack[top]];
                top--;
            }
            if (top >= 0) {
                int j = stack[top];
                if ((max[i] | nums[j]) > max[j]) {
                    res[i] += res[j];
                    max[i] |= nums[j];
                    min[i] = Math.min(min[i], min[j]);
                }
            }
            stack[++top] = i;
        }
        return re (!monoq.isEmpty() && (nums[i] | nums[monoq.peekLast()]) == nums[monoq.peekLast()]) {
                monoq.pollLast();
            }
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
         
        return ans;
    }
}