class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        
        int count = 0;
        boolean first = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (first) {
                    first = false;
                    continue;
                }
                if (count < k) {
                    return false;
                }
                count = 0;
            } else {
                count++;
            }
        }
        return true;
    }
}