class Solution {
    public int maxScore(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            if(prefix[i] > 0){
                max++;
            }
        }
        return max;
    }
}