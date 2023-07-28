class Solution {
    public int numSubseq(int[] nums, int target) {
        
        Arrays.sort(nums);
        int n = nums.length;
        long[] pow = new long[n];
        pow[0] = 1;
        for(int i=1; i<n; i++) {
            pow[i] = pow[i-1] * 2 % 1000000007;
        }
        int left = 0;
        int right = n - 1;
        long res = 0;
        while(left <= right) {
            if(nums[left] + nums[right] > target) {
                right--;
            } else {
                res += pow[right - left] % 1000000007;
                left++;
            }
        }
        return (int)res % 1000000007;
    }
}