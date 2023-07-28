class Solution {
    public int maximumTop(int[] nums, int k) {
        
        int n = nums.length;
        int[] cnt = new int[n + 1];
        for (int x : nums) {
            cnt[x]++;
        }
        for (int i = n; i >= 1; i--) {
            if (cnt[i] > k) {
                return i;
            }
            k -= cnt[i];
        }
        return -1;
    }
}