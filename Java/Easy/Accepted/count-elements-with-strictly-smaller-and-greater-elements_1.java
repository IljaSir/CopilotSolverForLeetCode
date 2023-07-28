class Solution {
    public int countElements(int[] nums) {
        
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean greater = false;
            boolean smaller = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    greater = true;
                } else if (nums[j] < nums[i]) {
                    smaller = true;
                }
            }
            if (greater && smaller) {
                count++;
            }
        }
        return count;
    }
}