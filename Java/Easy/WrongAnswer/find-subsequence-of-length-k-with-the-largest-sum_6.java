class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int[] arr = new int[k];
        int n = nums.length;
        int j = 0;
        for(int i = 0; i < n; i++){
            while(j > 0 && arr[j-1] < nums[i] && n - i > k - j){
                j--;
            }
            if(j < k){
                arr[j++] = nums[i];
            }
        }
        return arr;
    }
}