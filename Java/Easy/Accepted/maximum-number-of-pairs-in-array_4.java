class Solution {
    public int[] numberOfPairs(int[] nums) {
        
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }
        int pairs = 0;
        int left = 0;
        for (int i = 0; i < 101; i++) {
            if (freq[i] >= 2) {
                pairs += freq[i] / 2;
                freq[i] = freq[i] % 2;
            }
            if (freq[i] == 1) {
                left++;
            }
        }
        return new int[] {pairs, left};
    }
}