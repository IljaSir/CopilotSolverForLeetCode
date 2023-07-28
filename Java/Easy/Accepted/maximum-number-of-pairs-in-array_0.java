class Solution {
    public int[] numberOfPairs(int[] nums) {
        
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        int pairs = 0;
        for (int i = 0; i < 101; i++) {
            pairs += count[i] / 2;
            count[i] %= 2;
        }
        int left = 0;
        for (int i = 0; i < 101; i++) {
            if (count[i] == 1) {
                left++;
            }
        }
        return new int[]{pairs, left};
    }
}