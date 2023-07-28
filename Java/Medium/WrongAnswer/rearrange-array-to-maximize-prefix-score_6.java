class Solution {
    public int maxScore(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        int score = 0;
        for(int i=0; i<n; i++){
            if(prefix[i] > 0) score++;
        }
        return score;
    }
}