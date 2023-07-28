class Solution {
    public int[] numberOfPairs(int[] nums) {
        
        int[] counts = new int[101];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        int pairs = 0;
        int left = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                if (counts[i] % 2 == 0) {
                    pairs += counts[i] / 2;
                } else {
                    pairs += (counts[i] - 1) / 2;
                    left++;
                }
            }
        }
        return new int[]{pairs, left};
    }
}