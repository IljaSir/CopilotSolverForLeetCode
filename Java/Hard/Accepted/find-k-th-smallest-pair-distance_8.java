class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int h = nums[n - 1] - nums[0];
        while (l < h) {
            int m = l + (h - l) / 2;
            int count = 0;
            int start = 0;
            for (int end = 0; end < n; end++) {
                while (nums[end] - nums[start] > m) {
                    start++;
                }
                count += end - start;
            }
            if (count < k) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l;
    }
}