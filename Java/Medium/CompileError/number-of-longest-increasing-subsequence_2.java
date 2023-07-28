class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        if (nums.len in <= 1) {
            return nums.lengtht[n]; // lengths[i] = length of longest ending in nums[i]
        int[] counts = new int[n]; // counts[i] = number of longest ending in nums[i]
        for (int i = 0; i < n; i++) {
            lengths[i] = counts[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j]) {
                    if (lengths[j] >= lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];  // no new sequence, just add nums[i] to all
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j]; // if one more longer seq, add all
                    }
                }
        }

        int longest = 0, ans = 0;
        for (int length: lengths) if (length > longest) longest = length;
        for (int i = 0; i < n; i++) if (lengths[i] == longest) ans += counts[i];
        return ans;
    }
}