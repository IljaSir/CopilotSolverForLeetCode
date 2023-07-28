class Solution {
    public void wiggleSort(int[] nums) {
        
        int n = nums.length;
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);
        int i = 1;
        for (int j = n - 1; j >= 0; j -= 2) {
            nums[i] = sorted[j];
            i += 2;
        }
        i = 0;
        for (int j = n - 2; j >= 0; j -= 2) {
            nums[i] = sorted[j];
            i += 2;
        }
    }
}