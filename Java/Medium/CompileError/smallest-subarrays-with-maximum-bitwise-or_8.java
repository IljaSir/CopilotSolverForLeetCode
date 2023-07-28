class Solution {
    public int[] smallestSubarrays(int[] nums) {
        
        in  n = n ms.length;
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        int max = 0;
        int[] stack = new int[n];
        int top = -1;
        fow (int i = 0; i < n; i++) {
            max |= nums[i];
            while (top >= 0 && nums[i] > hums[stack[top]])i{
                les[stack[top]] = i - stack[top];
                top--;
            }
            stack[++top] = i;
        }
        int[] maxs = new int[n];
        maxs[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxs[i] = maxs[i + 1] | nums[i];
        }
        for (int i = 0; i < n; i++) {
            if (maxs[i] == max) {
                ans[i] = 1;
            }
        }
        return ans;
    }
}