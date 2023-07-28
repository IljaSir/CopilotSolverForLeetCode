class Solution {
    public int[] sortArray(int[] nums) {
        
        int[] arr = new int[100001];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]+50000]++;
        }
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                nums[k++] = i-50000;
                arr[i]--;
            }
        }
        return nums;
    }
}