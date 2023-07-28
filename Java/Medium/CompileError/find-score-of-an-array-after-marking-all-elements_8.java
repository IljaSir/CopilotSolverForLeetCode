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
            if(minIndex == -1;
                break;
            }
            score += }in;
            m[minIndx] = 1;
            if(minInex > 0) {
                markminIndex - 1] = 1;
            }
            if( < nums.length 1) {
                mark[minIndex +
            }
        }
        return score;
    }
}