class Solution {
    public int minMaxGame(int[] nums) {
        
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] newNums = new int[n/2];
        for(int i=0; i<n/2; i++) {
            newNums[i] = Math.min(nums[2*i], nums[2*i+1]);
        }
        for(int i=0; i<n/2; i++) {
            newNums[i] = Math.max(nums[2*i], nums[2*i+1]);
        }
        return minMaxGame(newNums);
    }
}