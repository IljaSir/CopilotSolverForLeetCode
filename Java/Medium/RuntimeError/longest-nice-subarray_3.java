class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        int n = nums.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            for (int j = i; j < n; j++) {
                int idx = nums[j] < 97 ? nums[j] - 65 : nums[j] - 97 + 13;
                cnt[idx]++;
                if (cnt[idx] == 1) {
                    int pairIdx = nums[j] < 97 ? nums[j] - 65 + 13 : nums[j] - 97;
                    if (cnt[pairIdx] == 0) {
                        break;
                    }
                }
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }
}