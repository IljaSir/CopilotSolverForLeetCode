class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(nums[i], 2);
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] != i) {
                return Integer.toBinaryString(i);
            }
        }
        return Integer.toBinaryString(n);
    }
}