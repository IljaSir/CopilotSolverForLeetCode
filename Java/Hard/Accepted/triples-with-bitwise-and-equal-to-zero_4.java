class Solution {
    public int countTriplets(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        int[] count = new int[1 << 16];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[nums[i] & nums[j]]++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < (1 << 16); k++) {
                if ((k & nums[i]) == 0) {
                    ans += count[k];
                }
            }
        }
        return ans;
    }
}