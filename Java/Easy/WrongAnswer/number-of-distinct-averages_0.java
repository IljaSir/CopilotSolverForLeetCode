class Solution {
    public int distinctAverages(int[] nums) {
        
        int n = nums.length;
        Set<Double> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                set.add((nums[i] + nums[j]) / 2.0);
            }
        }
        return set.size();
    }
}