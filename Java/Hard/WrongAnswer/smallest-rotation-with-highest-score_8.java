class Solution {
    public int bestRotation(int[] nums) {
        
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int left = (i - nums[i] + 1 + nums.length) % nums.length;
            int right = (i + 1) % nums.length;
            count[left]--;
            count[right]++;
            if (left > right) {
                count[0]--;
            }
        }
        int max = 0;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += count[i];
            if (sum > max) {
                max = sum;
                res = i;
            }
        }
        return res;
    }
}