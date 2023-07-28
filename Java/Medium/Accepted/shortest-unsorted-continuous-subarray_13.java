class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int start = 0;
        int end = n - 1;
        while (start < n && nums[start] == arr[start]) {
            start++;
        }
        while (start < end && nums[end] == arr[end]) {
            end--;
        }
        return end - start + 1;
    }
}