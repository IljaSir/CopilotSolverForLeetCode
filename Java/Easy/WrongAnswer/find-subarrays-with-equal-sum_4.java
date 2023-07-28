class Solution {
    public boolean findSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (prefix[j] - prefix[i] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}