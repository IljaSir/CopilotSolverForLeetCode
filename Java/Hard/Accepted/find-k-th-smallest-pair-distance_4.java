class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = nums[n - 1] - nums[0];
        while (l < r) {
            int mid = l + (r - l) / 2;
            int count = 0, start = 0;
            for (int i = 0; i < n; i++) {
                while (nums[i] - nums[start] > mid) {
                    start++;
                }
                count += i - start;
            }
            if (count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}