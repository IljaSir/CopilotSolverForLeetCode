class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];
            int[] temp = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                temp[j] = Integer.parseInt(nums[j].substring(nums[j].length() - trim));
            }
            Arrays.sort(temp);
            result[i] = temp[k - 1];
        }
        return result;
    }
}