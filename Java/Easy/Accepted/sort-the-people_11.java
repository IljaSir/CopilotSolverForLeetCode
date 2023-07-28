class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        // sorting
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights.length; j++) {
                if (heights[i] > heights[j]) {
                    int temp = heights[i];
                    heights[i] = heights[j];
                    heights[j] = temp;

                    String temp1 = names[i];
                    names[i] = names[j];
                    names[j] = temp1;
                }
            }
        }
        return names;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] names = new String[]{"Mary","John","Emma"};
        int[] heights = new int[]{180,165,170};
        String[] result = solution.sortPeople(names, heights);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}