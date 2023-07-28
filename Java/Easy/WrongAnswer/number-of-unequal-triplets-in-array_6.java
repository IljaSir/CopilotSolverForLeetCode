class Solution {
    public int unequalTriplets(int[] nums) {
        
        int n = nums.length;
        int[] cnt = new int[1001];
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        int ans = 0;
        for (int i = 1; i <= 1000; i++) {
            for (int j = i + 1; j <= 1000; j++) {
                for (int k = j + 1; k <= 1000; k++) {
                    if (cnt[i] > 0 && cnt[j] > 0 && cnt[k] > 0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}