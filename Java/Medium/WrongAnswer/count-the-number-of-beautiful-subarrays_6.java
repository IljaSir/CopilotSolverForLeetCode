class Solution {
    public long beautifulSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] even = new int[n];
        int[] odd = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                even[i] = i > 0 ? even[i - 1] + 1 : 1;
                odd[i] = i > 0 ? odd[i - 1] : 0;
            } else {
                odd[i] = i > 0 ? even[i - 1] + 1 : 1;
                even[i] = i > 0 ? odd[i - 1] : 0;
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += odd[i];
        }
        return ans;
    }
}