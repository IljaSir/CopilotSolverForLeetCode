class Solution {
    public int countSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] count = new int[n + 1];
        int[] prefix = new int[n + 1];
        int res = 0;
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
            prefix[nums[i]] += nums[i];
            if (nums[i] > k) {
                count[nums[i]] += count[nums[i] - 1];
                prefix[nums[i]] += prefix[nums[i] - 1];
            }
            if (nums[i] < k) {
                int left = nums[i] - 1;
                int right = k - 1;
                int sum = prefix[right] - prefix[left];
                int cnt = count[right] - count[left];
                res += cnt * k - sum;
            }
        }
        return res;
    }
}