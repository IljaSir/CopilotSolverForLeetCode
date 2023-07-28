class Solution {
    public void wiggleSort(int[] nums) {
        
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        int i = nums.length - 1;
        int j = 0;
        int k = 0;
        while (i >= 0) {
            if (k % 2 == 0) {
                nums[k] = arr[i--];
            } else {
                nums[k] = arr[j++];
            }
            k++;
        }
    }
}