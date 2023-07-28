class Solution {
    public int minSwaps(int[] nums) {
        
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                cnt++;
            }
        }
        int max = 0;
        for (int i = 0; i < cnt; i++) {
            if (nums[i] == 1) {
                max++;
            }
        }
        int cur = max;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] == 1) {
                cur--;
            }
            if (nums[(i + cnt - 1) % n] == 1) {
                cur++;
            }
            max = Math.max(max, cur);
        }
        return cnt - max;
    }
}