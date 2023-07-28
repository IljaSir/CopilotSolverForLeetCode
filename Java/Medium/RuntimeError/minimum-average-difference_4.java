class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int ans = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int left = i + 1;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int sumLeft = preSum[i + 1];
                int sumRight = preSum[n] - preSum[mid];
                int avgLeft = sumLeft / (i + 1);
                int avgRight = sumRight / (n - mid);
                if (avgLeft <= avgRight) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int sumLeft = preSum[i + 1];
            int sumRight = preSum[n] - preSum[left];
            int avgLeft = sumLeft / (i + 1);
            int avgRight = sumRight / (n - left);
            int diff = Math.abs(avgLeft - avgRight);
            if (diff < minDiff) {
                minDiff = diff;
                ans = i;
            }
        }
        return ans;
    }
}