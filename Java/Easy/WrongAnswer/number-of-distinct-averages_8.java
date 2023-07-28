class Solution {
    public int distinctAverages(int[] nums) {
        
        int n = nums.length;

        // sort the array
        Arrays.sort(nums);

        // count the number of distinct averages
        Set<Double> averages = new HashSet<>();
        for (int i = 0; i < n / 2; i++) {
            for (int j = n - 1; j >= n / 2; j--) {
                averages.add((nums[i] + nums[j]) / 2.0);
            }
        }

        return averages.size();
    }
}