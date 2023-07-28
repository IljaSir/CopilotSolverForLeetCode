class Solution {
    public int subarrayLCM(int[] nums, int k) {
        
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int lcm = nums[i];
            if (lcm == k) ans++;
            for (int j = i + 1; j < n; j++) {
                lcm = lcm(lcm, nums[j]);
                if (lcm > k) break;
                if (lcm == k) ans++;
            }
        }
        return ans;
    }
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}