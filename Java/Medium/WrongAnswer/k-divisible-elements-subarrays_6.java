class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[p];
            int total = 0;
            for (int j = i; j < n; j++) {
                if (cnt[nums[j] % p] == 0) {
                    total++;
                }
                cnt[nums[j] % p]++;
                if (total <= k) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}