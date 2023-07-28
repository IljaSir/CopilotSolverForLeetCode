class Solution {
    public int distinctAverages(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Set<Double> set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                double avg = (sum[j + 1] - sum[i]) * 1.0 / (j - i + 1);
                set.add(avg);
            }
        }
        return set.size();
    }
}