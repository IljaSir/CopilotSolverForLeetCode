class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        int[] answer = new int[queries.length];
        Arrays.sort(nums);
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int start = 0;
            int end = nums.length - 1;
            int result = -1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (prefixSum[mid + 1] <= queries[i]) {
                    result = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            answer[i] = result + 1;
        }
        return answer;
    }
}