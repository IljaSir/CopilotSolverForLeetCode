class Solution {
    public void wiggleSort(int[] nums) {
        
        Arrays.sort(nums);
        int[] temp = new int[nums.length];
        int mid = (nums.length - 1) / 2;
        int index = 0;
        for (int i = 0; i <= mid; i++) {
            temp[index] = nums[mid - i];
            if (index + 1 < nums.length) {
                temp[index + 1] = nums[nums.length - 1 - i];
            }
            index += 2;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}