class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0], trim = queries[i][1];
            String[] trimmedNums = new String[nums.length];
            for (int j = 0; j < nums.length; j++) {
                trimmedNums[j] = nums[j].substring(0, trim);
            }
            Arrays.sort(trimmedNums);
            answer[i] = Integer.parseInt(trimmedNums[k - 1]);
        }
        return answer;
    }
}