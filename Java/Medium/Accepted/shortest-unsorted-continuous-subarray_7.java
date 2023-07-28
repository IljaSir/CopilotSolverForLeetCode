class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int n = nums.length;
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);
        int i = 0;
        while (i < n && nums[i] == sorted[i]) {
            i++;
        }
        int j = n - 1;
        while (j > i && nums[j] == sorted[j]) {
            j--;
        }
        return j - i + 1;
    }
}