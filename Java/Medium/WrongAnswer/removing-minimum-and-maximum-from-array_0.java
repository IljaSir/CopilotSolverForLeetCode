class Solution {
    public int minimumDeletions(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        for(int i=1;i<n;i++){
            left[i] = Math.min(left[i-1], nums[i]);
        }
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1], nums[i]);
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i<n-1;i++){
            if(left[i-1] < nums[i] && nums[i] < right[i+1]){
                min = Math.min(min, i);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}