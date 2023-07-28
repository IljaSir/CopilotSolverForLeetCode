class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        
        int n = nums.length;
        int[] rightOnes = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            rightOnes[i] = nums[i] + (i == n - 1 ? 0 : rightOnes[i + 1]);
        }
        int maxScore = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int leftZeros = i;
            int rightOnes = i == n - 1 ? 0 : rightOnes[i + 1];
            int score = leftZeros + rightOnes;
            if (score > maxScore) {
                maxScore = score;
                result.clear();
                result.add(i);
            } else if (score == maxScore) {
                result.add(i);
            }
        }
        return result;
    }
}