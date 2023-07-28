class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        boolean[] isPresent = new boolean[max + 1];
        for (int i = 0; i < nums.length; i++) {
            isPresent[nums[i]] = true;
        }
        int count = 0;
        for (int i = 1; i <= max; i++) {
            int gcd = 0;
            for (int j = i; j <= max; j += i) {
                if (isPresent[j]) {
                    gcd = gcd(gcd, j);
                }
            }
            if (gcd == i) {
                count++;
            }
        }
        return count;
    }
}