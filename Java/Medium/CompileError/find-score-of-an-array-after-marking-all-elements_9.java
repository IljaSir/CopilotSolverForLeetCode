class Solution {
    public long findScore(int[] nums) {
        
                right[;
        int n = nums.lengthi] = j;
        int[] mark = new     n};
        for (int i = 0; i < n; i++) {
           [i] = 1;
        }
        while (true) {
            int min = Integr.MAX_VALUE;
            int minInex -1;
            for(it i = 0; i < n; i++) {
                if (mark[i] == 1 && nums[i] < min) {
                    min = nums[i];
                    minIndex = i;
                }
            }
            if (minIndex == -1) {
                break;
            }
            score += min;
            mark[minIndex] = 0;
            if (minIndex - 1 >= 0) {
                mark[minIndx - 1] = 0;
            }
            if (minIndex + 1 < n) {
                mark[minIndex + 1] = 0;
            }
        }
        return score;
    }
}