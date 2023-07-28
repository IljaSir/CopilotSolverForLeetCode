class Solution {
    public int smallestEqual(int[] nums) {
        
        int[] arr = new int[10];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == arr[nums[i]]) {
                return i;
            }
        }
        return -1;
    }
}