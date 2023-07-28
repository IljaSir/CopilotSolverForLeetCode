class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        int[] freq = new int[max + 1];
        for (int n : nums) {
            freq[n]++;
        }
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            if (freq[i] > 0) {
                ans++;
            }
            for (int j = 2 * i; j <= max; j += i) {
                freq[i] += freq[j];
            }
        }
        return ans;
    }
}