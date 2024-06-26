class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int sum = 0;
            int count = 0;
            for(int j=0;j<nums.length;j++){
                if(sum+nums[j]<=queries[i]){
                    sum+=nums[j];
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}