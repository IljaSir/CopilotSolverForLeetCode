class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] max = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + (nums[i - 1] == 0 ? 1 : 0);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (nums[i + 1] == 1 ? 1 : 0);
        }
        for (int i = 0; i < n; i++) {
            max[i] = left[i] + right[i];
        }
        int maxScore = 0;
        for (int i = 0; i < n; i++) {
            maxScore = Math.max(maxScore, max[i]);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (maxScore == max[i]) {
                result.add(i);
            }
        }
        return result;
    }
}