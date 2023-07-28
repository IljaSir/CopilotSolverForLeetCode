class Solution {
    public int maxSumMinProduct(int[] nums) {
        
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = nums.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i] = nums.length;
            }else{
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        long[] sum = new long[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        long mod = 1000000007;
        long max = 0;
        for(int i = 0; i < nums.length; i++){
            long l = left[i] + 1;
            long r = right[i] - 1;
            long s = sum[(int)r + 1] - sum[(int)l];
            max = Math.max(max, s * nums[i]);
        }
        return (int)(max % mod);
    }
}