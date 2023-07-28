class Solution {
    public int countTriplets(int[] nums) {
        
        int n = nums.length;
        int[] cnt = new int[1 << 16];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt[nums[i] & nums[j]]++;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < (1 << 16); k++) {
                if ((nums[i] & k) == 0) {
                    ans += cnt[k];
                }
            }
        }
        return ans;
    }
}