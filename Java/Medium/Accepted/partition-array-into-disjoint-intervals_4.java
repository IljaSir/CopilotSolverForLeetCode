class Solution {
    public int partitionDisjoint(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        for(int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], nums[i]);
        }
        for(int i = n-2; i >= 0; i--) {
            right[i] = Math.min(right[i+1], nums[i]);
        }
        for(int i = 1; i < n; i++) {
            if(left[i-1] <= right[i]) return i;
        }
        return -1;
    }
}