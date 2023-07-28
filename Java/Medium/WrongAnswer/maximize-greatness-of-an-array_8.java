class Solution {
    public int maximizeGreatness(int[] nums) {
        
        int[] count = new int[1000001];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        int[] prefix = new int[1000001];
        for (int i = 1; i < 1000001; i++) {
            prefix[i] = prefix[i - 1] + count[i];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            int left = prefix[cur - 1];
            int right = n - prefix[cur] - 1;
            res = Math.max(res, left + right);
        }
        return res;
    }
}