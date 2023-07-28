class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        int[] answer = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] <= query) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            answer[i] = left;
        }
        return answer;
    }
}