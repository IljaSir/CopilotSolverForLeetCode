class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        
        int n = nums.length;
        int[] sum = new int[n+1];
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        int l = 1, r = n;
        while(l <= r){
            int m = l + (r-l)/2;
            if(check(m, sum, threshold)){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return r;
    }
    private boolean check(int m, int[] sum, int threshold){
        for(int i = m; i < sum.length; i++){
            if(sum[i] - sum[i-m] > threshold){
                return true;
            }
        }
        return false;
    }
}