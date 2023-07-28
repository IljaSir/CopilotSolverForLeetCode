class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        int[] res = new int[nums.length];
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - k - 1 >= 0) {
                sum -= nums[i - k - 1];
                count--;
            }
            if (i + k < nums.length) {
                sum += nums[i + k];
                count++;
            }
            res[i] = count == 0 ? -1 : sum / count;
        }
        return res;
    }
}