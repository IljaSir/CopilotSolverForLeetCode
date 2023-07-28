class Solution {
    public long minimumReplacement(int[] nums) {
        
        long total = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x % 2 == 0) {
                continue;
            }
            total++;
            if (i + 1 < n && nums[i + 1] % 2 == 1) {
                i++;
            }
        }
        return total;
    }
}