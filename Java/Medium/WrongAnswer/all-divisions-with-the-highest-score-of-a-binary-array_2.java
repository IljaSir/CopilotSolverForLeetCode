class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        
        int[] ones = new int[nums.length];
        int[] zeros = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ones[i] = nums[i] == 1 ? 1 : 0;
            zeros[i] = nums[i] == 0 ? 1 : 0;
        }
        for (int i = 1; i < nums.length; i++) {
            ones[i] += ones[i - 1];
            zeros[i] += zeros[i - 1];
        }
        int max = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int score;
            if (i == 0) {
                score = ones[nums.length - 1];
            } else if (i == nums.length - 1) {
                score = zeros[nums.length - 1];
            } else {
                score = zeros[i - 1] + ones[nums.length - 1] - ones[i];
            }
            if (score > max) {
                max = score;
                ans.clear();
                ans.add(i);
            } else if (score == max) {
                ans.add(i);
            }
        }
        return ans;
    }
}