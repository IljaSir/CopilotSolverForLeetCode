class Solution {
    public int thirdMax(int[] nums) {
        
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int n : nums) {
            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n < first && n > second) {
                third = second;
                second = n;
            } else if (n < second && n > third) {
                third = n;
            }
        }
        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }
}