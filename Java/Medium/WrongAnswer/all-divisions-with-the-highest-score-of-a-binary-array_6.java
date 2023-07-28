class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] == 0) left++;
            }
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 1) right++;
            }
            int score = left + right;
            if (score > max) {
                max = score;
                result.clear();
                result.add(i);
            } else if (score == max) {
                result.add(i);
            }
        }
        return result;
    }
}