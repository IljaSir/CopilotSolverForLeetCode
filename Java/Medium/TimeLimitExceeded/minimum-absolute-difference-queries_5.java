class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int[] subArray = Arrays.copyOfRange(nums, query[0], query[1] + 1);
            Arrays.sort(subArray);
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < subArray.length - 1; j++) {
                if (subArray[j] != subArray[j + 1]) {
                    min = Math.min(min, subArray[j + 1] - subArray[j]);
                }
            }
            result[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return result;
    }
}