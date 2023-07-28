class Solution {
    public int[] numberOfPairs(int[] nums) {
        
        int[] count = new int[101];
        int pair = 0;
        for (int n : nums) {
            if (count[n] > 0) {
                pair++;
                count[n]--;
            } else {
                count[n]++;
            }
        }
        return new int[] {pair, Arrays.stream(count).sum()};
    }
}