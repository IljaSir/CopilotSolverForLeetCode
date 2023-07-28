class Solution {
    public long countQuadruplets(int[] nums) {
        
        long cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] < nums[k] && nums[k] < nums[j] && nums[j] < nums[l]) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}