class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        
        int[] answer = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            answer[i++] = getKthSmallest(nums, query[0], query[1]);
        }
        return answer;
    }
    
    private int getKthSmallest(String[] nums, int k, int trim) {
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = Integer.parseInt(nums[i].substring(nums[i].length() - trim));
        }
        Arrays.sort(array);
        return array[k - 1];
    }
}