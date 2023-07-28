class Solution {
    public int distinctAverages(int[] nums) {
        
        Set<Double> set = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n / 2; i++) {
            for(int j = n - 1; j >= n / 2; j--) {
                set.add((nums[i] + nums[j]) / 2.0);
            }
        }
        return set.size();
    }
}