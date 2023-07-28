class Solution {
    public int[] numberOfPairs(int[] nums) {
        
        int[] arr = new int[101];
        int pairs = 0;
        for (int n : nums) {
            arr[n]++;
        }
        for (int i = 0; i < 101; i++) {
            pairs += arr[i] / 2;
        }
        int left = 0;
        for (int i = 0; i < 101; i++) {
            if (arr[i] % 2 == 1) {
                left++;
            }
        }
        return new int[]{pairs, left};
    }
}