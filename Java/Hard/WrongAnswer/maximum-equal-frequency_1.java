class Solution {
    public int maxEqualFreq(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[n + 1];
        int[] freq = new int[n + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            freq[count[x]]--;
            count[x]++;
            freq[count[x]]++;
            if (freq[count[x]] * count[x] == i + 1) {
                ans = i + 1;
            }
            if (freq[1] == i + 1) {
                ans = i + 1;
            }
            if (freq[i + 1] == 1) {
                ans = i + 1;
            }
        }
        return ans;
    }
}