class Solution {
    public int[] smallestSubarrays(int[] nums) {
        
        int[] res = new int[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max |= nums[i];
        }
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i] = max;
        }
        int[] stack = new int[nums.length];
        int top = -1;
        for(int i = 0; i < nums.length; i++){
            while(top > -1 && nums[i] > nums[stack[top]]){
                dp[stack[top]] = i - stack[top];
                top--;
            }
            stack[++top] = i;
        }
        for(int i = 0; i < nums.length; i++){
            res[i] = dp[i];
        }
        return res;
    }
}