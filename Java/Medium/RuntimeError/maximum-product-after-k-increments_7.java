class Solution {
    public int maximumProduct(int[] nums, int k) {
        
        int n = nums.length;
        int mod = 1000000007;
        Arrays.sort(nums);
        long max = 1;
        int i = 0;
        int j = n - 1;
        if (k % 2 == 1) {
            max = nums[j];
            j--;
            k--;
        }
        while (k > 0) {
            long a = nums[i] * nums[i + 1];
            long b = nums[j] * nums[j - 1];
            if (a > b) {
                max = (max * a) % mod;
                i += 2;
            } else {
                max = (max * b) % mod;
                j -= 2;
            }
            k -= 2;
        }
        return (int) max;
    }
}