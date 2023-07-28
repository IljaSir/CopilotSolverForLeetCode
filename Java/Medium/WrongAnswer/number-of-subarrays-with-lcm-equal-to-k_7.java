class Solution {
    public int subarrayLCM(int[] nums, int k) {
        
        int n = nums.length;
        int[] pre = new int[n+1];
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                int sum = pre[j] - pre[i];
                if (sum % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}