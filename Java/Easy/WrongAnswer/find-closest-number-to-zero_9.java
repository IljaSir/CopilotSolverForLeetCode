class Solution {
    public int findClosestNumber(int[] nums) {
        
        // sort the array
        Arrays.sort(nums);
        // create a variable to store the closest number
        int num = 0;
        // create a variable to store the closest distance
        int distance = Integer.MAX_VALUE;
        // loop through the array
        for (int i = 0; i < nums.length; i++) {
            // if the distance is less than the closest distance
            if (Math.abs(nums[i]) < distance) {
                // update the closest distance
                distance = Math.abs(nums[i]);
                // update the closest number
                num = nums[i];
            }
        }
        // return the closest number
        return num;
    }
}