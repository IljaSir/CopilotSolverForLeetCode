class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        int n = nums.length;
        int[] freq = new int[n + 1];
        int left = 0, right = 0;
        int res = 0;
        int cnt = 0;
        while (right < n) {
            if (freq[nums[right]] == 0) {
                cnt++;
            }
            freq[nums[right]]++;
            right++;
            while (cnt > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    cnt--;
                }
                left++;
            }
            int tempLeft = left;
            while (freq[nums[tempLeft]] > 1) {
                freq[nums[tempLeft]]--;
                tempLeft++;
            }
            res += tempLeft - left + 1;
        }
        return res;
    }
}