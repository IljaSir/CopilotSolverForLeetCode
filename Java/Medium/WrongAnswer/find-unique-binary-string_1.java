class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(nums[i], 2);
        }
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != res) {
                break;
            }
            res++;
        }
        return Integer.toBinaryString(res);
    }
}