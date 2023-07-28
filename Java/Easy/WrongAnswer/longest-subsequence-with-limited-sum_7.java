class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        int[] answer = new int[queries.length];
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i-1] + nums[i];
        for (int i = 0; i < queries.length; i++) {
            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (sum[mid] <= queries[i])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            if (sum[mid] > queries[i])
                mid--;
            answer[i] = mid + 1;
        }
        return answer;
    }
}