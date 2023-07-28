class Solution {
    public int[] numberOfPairs(int[] nums) {
        
        int[] count = new int[101];
        for (int n : nums) {
            count[n]++;
        }
        int pairs = 0;
        for (int i = 0; i < 101; i++) {
            pairs += count[i] / 2;
        }
        int left = 0;
        for (int i = 0; i < 101; i++) {
            left += count[i] % 2;
        }
        return new int[] {pairs, left};
    }
}