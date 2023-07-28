class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        
        int[] res = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            int count = 0;
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] >= heights[i]) {
                    count++;
                    break;
                }
                count++;
            }
            res[i] = count;
        }
        return res;
    }
}