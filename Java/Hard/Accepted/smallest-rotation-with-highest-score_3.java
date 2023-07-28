class Solution {
    public int bestRotation(int[] nums) {
        
        int n = nums.length;
        int[] change = new int[n];
        for (int i = 0; i < n; i++) {
            change[(i - nums[i] + 1 + n) % n]--;
        }
        for (int i = 1; i < n; i++) {
            change[i] += change[i - 1] + 1;
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (change[i] > change[ans]) {
                ans = i;
            }
        }
        return ans;
    }
}