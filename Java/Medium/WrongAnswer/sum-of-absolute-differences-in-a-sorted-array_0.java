class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        for (int i = 1; i < n; ++i) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = n - 2; i >= 0; --i) {
            suffix[i] = suffix[i + 1] + nums[i];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            int left = i * nums[i] - (i > 0 ? prefix[i - 1] : 0);
            int right = (n - i - 1) * nums[i] - (i < n - 1 ? suffix[i + 1] : 0);
            result[i] = left + right;
        }
        return result;
    }
}