class Solution {
    public int heightChecker(int[] heights) {
        
        int[] expectedHeights = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expectedHeights);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expectedHeights[i]) {
                count++;
            }
        }
        return count;
    }
}