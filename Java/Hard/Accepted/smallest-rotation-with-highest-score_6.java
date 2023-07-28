class Solution {
    public int bestRotation(int[] nums) {
        
        int n = nums.length;
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            int left = (i - nums[i] + 1 + n) % n;
            int right = (i + 1) % n;
            score[left]--;
            score[right]++;
            if (left > right) {
                score[0]--;
            }
        }
        int best = -n;
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += score[i];
            if (cur > best) {
                best = cur;
                ans = i;
            }
        }
        return ans;
    }
}