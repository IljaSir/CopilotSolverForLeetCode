class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = Arrays.binarySearch(sorted, nums[i]);
        }
        return result;
    }
}