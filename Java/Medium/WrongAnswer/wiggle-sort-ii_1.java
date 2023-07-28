class Solution {
    public void wiggleSort(int[] nums) {
        
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        Arrays.sort(temp);
        int i = 0, j = (n + 1) / 2, k = n - 1;
        while (i < n) {
            nums[i++] = temp[k--];
            if (i < n) {
                nums[i++] = temp[j++];
            }
        }
    }
}