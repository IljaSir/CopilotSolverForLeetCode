class Solution {
    public int countDistinctIntegers(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int reverse = 0;
            while (num > 0) {
                reverse = reverse * 10 + num % 10;
                num /= 10;
            }
            set.add(reverse);
        }
        return set.size();
    }
}