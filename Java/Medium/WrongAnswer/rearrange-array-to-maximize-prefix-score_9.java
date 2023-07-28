class Solution {
    public int maxScore(int[] nums) {
        
        int score = 0;
        Arrays.sort(nums);
        int prefix = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                prefix += nums[i];
                score++;
            }
        }
        return score;
    }
}