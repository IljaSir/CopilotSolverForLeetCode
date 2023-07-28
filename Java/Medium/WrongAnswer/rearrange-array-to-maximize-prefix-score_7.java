class Solution {
    public int maxScore(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
        for(int i=n-2;i>=0;i--){
            suffix[i] = suffix[i+1]+nums[i];
        }
        int max = 0;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                max++;
            }
            if(i<n-1 && prefix[i]>0){
                max++;
            }
            if(i>0 && suffix[i]>0){
                max++;
            }
        }
        return max;
    }
}