class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        int[] result = new int[nums.length];
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        while (right < nums.length) {
            sum += nums[right];
            count++;
            if (right - left + 1 > 2 * k + 1) {
                sum -= nums[left];
                count--;
                left++;
            }
            if (right - left + 1 == 2 * k + 1) {
                result[left + k] = sum / count;
            }
            right++;
        }
        return result;
    }
}