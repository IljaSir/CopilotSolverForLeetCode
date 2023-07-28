class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = getKthSmallest(nums, queries[i][0], queries[i][1]);
        }
        return result;
    }
    
    private int getKthSmallest(String[] nums, int k, int trim) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.parseInt(nums[i].substring(0, nums[i].length() - trim));
        }
        Arrays.sort(arr);
        return arr[k - 1];
    }
}