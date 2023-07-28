class Solution {
    public int countElements(int[] nums) {
        
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int greater = 0;
            int smaller = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    smaller++;
                }
                if (nums[i] < nums[j]) {
                    greater++;
                }
            }
            if (greater > 0 && smaller > 0) {
                count++;
            }
        }
        return count;
    }
}