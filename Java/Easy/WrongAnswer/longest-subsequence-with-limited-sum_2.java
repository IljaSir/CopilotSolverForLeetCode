class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int max = 0;
            for (int j = 0; j < nums.length; j++) {
                int sum = 0;
                for (int k = j; k < nums.length; k++) {
                    sum += nums[k];
                    if (sum <= queries[i]) {
                        max = Math.max(max, k - j + 1);
                    }
                }
            }
            answer[i] = max;
        }
        return answer;
    }
}