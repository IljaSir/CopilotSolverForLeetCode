class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }
        int[] newNums = new int[n];
        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            newNums[newIndex] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = newNums[i];
        }
    }
}