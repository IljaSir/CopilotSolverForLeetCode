class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int count = 0;
            int sum = 0;
            int j = 0;
            while(j < nums.length && sum < queries[i]){
                if(sum + nums[j] <= queries[i]){
                    sum += nums[j];
                    count++;
                }
                j++;
            }
            answer[i] = count;
        }
        return answer;
    }
}