class Solution {
    public long findScore(int[] nums) {
        
        long score = 0;
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(nums, arr[i]);
            score += arr[i];
            mark(nums, index);
        }
        return score;
    }
    
    public void mark(int[] nums, int index) {
        if (index >= 0 && index < nums.length) {
            nums[index] = -1;
            if (index > 0) {
                nums[index - 1] = -1;
            }
            if (index < nums.length - 1) {
                nums[index + 1] = -1;
            }
        }
    }
}