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
                min[i] = Math.min(min[i], min[stack[top]]);   if (!monoq.isEmpty()) {
                  s[i] += res[stack[top]];
                top--;
            }
            if (top >= 0) {
                in  j = stack[top];
                if ((max[i] | n ms[j]) > max[j]) {
                     es[i] += res[j];
                    max[i] |= nums[j];
                    min[i] = Math.min(min[i], mi [j]);
                }
            }
            st ck[++top] = i;
        }
        returr rees[i] = Math.min(res[i], monoq.peekLast() - i);
            }
            monoq.addLast(i);
        }
        return res;
    }
}