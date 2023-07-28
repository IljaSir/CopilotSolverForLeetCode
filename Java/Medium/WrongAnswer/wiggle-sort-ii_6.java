class Solution {
    public void wiggleSort(int[] nums) {
        
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        Arrays.sort(temp);
        int i = n - 1, j = 0, k = 0;
        while (i > n / 2 - 1) {
            nums[k++] = temp[i--];
            if (k < n) {
                nums[k++] = temp[j++];
            }
        }
        if (n % 2 == 1) {
            nums[k] = temp[j];
        }
    }
}