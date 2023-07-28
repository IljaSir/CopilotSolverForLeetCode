class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int max = 0;
        for (int i = 0; i < nums.length - firstLen + 1; i++) {
            int first = prefix[i + firstLen] - prefix[i];
            int second = 0;
            for (int j = 0; j < nums.length - secondLen + 1; j++) {
                if (j >= i && j <= i + firstLen) {
                    continue;
                }
                second = Math.max(second, prefix[j + secondLen] - prefix[j]);
            }
            max = Math.max(max, first + second);
        }
        for (int i = 0; i < nums.length - secondLen + 1; i++) {
            int first = prefix[i + secondLen] - prefix[i];
            int second = 0;
            for (int j = 0; j < nums.length - firstLen + 1; j++) {
                if (j >= i && j <= i + secondLen) {
                    continue;
                }
                second = Math.max(second, prefix[j + firstLen] - prefix[j]);
            }
            max = Math.max(max, first + second);
        }
        return max;
    }
}