class Solution {
    public int maxProductDifference(int[] nums) {
        
        int max1 = 0;
        int max2 = 0;
        int min1 = 10001;
        int min2 = 10001;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return max1 * max2 - min1 * min2;
    }
}