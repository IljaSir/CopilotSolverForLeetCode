class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = left[i - 1] + nums[i - 1];
        }
        for (int i = n - 2; i >= 0; --i) {
            right[i] = right[i + 1] + nums[i + 1];
        }
        int max = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int score = left[i] + right[i];
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
    }
}