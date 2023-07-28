class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int s : sum) {
            ans += cnt.getOrDefault(s, 0);
            cnt.put(s + goal, cnt.getOrDefault(s + goal, 0) + 1);
        }
        return ans;
    }
}