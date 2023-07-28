class Solution {
    public int distinctAverages(int[] nums) {
        
        Set<Double> res = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; i++) {
            for (int j = i + 1; j < n / 2 + 1; j++) {
                res.add((nums[i] + nums[n - j]) / 2.0);
            }
        }
        return res.size();
    }
}