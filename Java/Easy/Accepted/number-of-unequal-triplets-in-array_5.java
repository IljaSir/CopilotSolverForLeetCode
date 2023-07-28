class Solution {
    public int unequalTriplets(int[] nums) {
        
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int second = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int third = nums[k];
                    if (first != second && second != third && first != third) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}