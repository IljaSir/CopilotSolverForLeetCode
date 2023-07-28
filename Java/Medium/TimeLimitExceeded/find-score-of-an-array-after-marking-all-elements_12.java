class Solution {
    public long findScore(int[] nums) {
        
        long score = 0;
        int[] mark = new int[nums.length];
        while(true) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int i = 0; i < nums.length; i++) {
                if(mark[i] == 0 && nums[i] < min) {
                    min = nums[i];
                    minIndex = i;
                }
            }
            if(minIndex == -1) {
                break;
            }
            score += min;
            mark[minIndex] = 1;
            if(minIndex > 0) {
                mark[minIndex - 1] = 1;
            }
            if(minIndex < nums.length - 1) {
                mark[minIndex + 1] = 1;
            }
        }
        return score;
    }
}