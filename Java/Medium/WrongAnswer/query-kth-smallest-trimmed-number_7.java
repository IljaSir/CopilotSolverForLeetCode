class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];
            String[] trimmed = new String[nums.length];
            for(int j = 0; j < nums.length; j++) {
                trimmed[j] = nums[j].substring(nums[j].length() - trim);
            }
            Arrays.sort(trimmed);
            res[i] = Integer.parseInt(trimmed[k-1]);
        }
        return res;
    }
}