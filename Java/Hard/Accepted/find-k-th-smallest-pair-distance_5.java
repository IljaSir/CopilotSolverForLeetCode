class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = nums[n - 1] - nums[0];
        while (l < r) {
            int mid = l + r >> 1;
            int cnt = 0, j = 0;
            for (int i = 0; i < n; i++) {
                while (j < n && nums[j] - nums[i] <= mid) j++;
                cnt += j - i - 1;
            }
            if (cnt < k) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}