class Solution {
    public boolean divideArray(int[] nums) {
        
        if (nums.length % 2 != 0) {
            return false;
        }
        int[] count = new int[501];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}