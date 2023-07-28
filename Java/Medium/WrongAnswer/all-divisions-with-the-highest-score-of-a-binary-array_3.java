class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] ones = new int[n];
        int[] zeros = new int[n];
        ones[n - 1] = nums[n - 1];
        zeros[n - 1] = nums[n - 1] == 0 ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            ones[i] = ones[i + 1] + (nums[i] == 1 ? 1 : 0);
            zeros[i] = zeros[i + 1] + (nums[i] == 0 ? 1 : 0);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int score = zeros[i] + ones[i];
            if (score > max) {
                max = score;
                res.clear();
                res.add(i);
            } else if (score == max) {
                res.add(i);
            }
        }
        return res;
    }
}