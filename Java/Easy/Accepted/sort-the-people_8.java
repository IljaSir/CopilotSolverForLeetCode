class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        String[] result = new String[names.length];
        int[] indexes = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            indexes[i] = i;
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights.length - i - 1; j++) {
                if (heights[j] < heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    temp = indexes[j];
                    indexes[j] = indexes[j + 1];
                    indexes[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < indexes.length; i++) {
            result[i] = names[indexes[i]];
        }
        return result;
    }
}