class Solution {
    public int countMaxOrSubsets(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, nums[i] | nums[j]);
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((nums[i] | nums[j]) == max) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}