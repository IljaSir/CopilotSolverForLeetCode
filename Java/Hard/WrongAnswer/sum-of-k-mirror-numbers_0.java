class Solution {
    public long kMirror(int k, int n) {
        
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return sum;
    }
}