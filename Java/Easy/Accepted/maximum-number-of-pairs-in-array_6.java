class Solution {
    public int[] numberOfPairs(int[] nums) {
        
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        int pairs = 0, left = 0;
        for (int i = 0; i <= 100; i++) {
            pairs += count[i] / 2;
            left += count[i] % 2;
        }
        return new int[]{pairs, left};
    }
}