class Solution {
    public int distinctAverages(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        Set<Double> set = new HashSet<>();
        for (int i = 0; i < n / 2; i++) {
            for (int j = i + 1; j < n / 2 + 1; j++) {
                set.add((nums[i] + nums[n - j]) / 2.0);
            }
        }
        return set.size();
    }
}