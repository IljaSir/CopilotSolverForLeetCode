class Solution {
    public List<Integer> intersection(int[][] nums) {
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
        }
        for (int i = 0; i < nums[0].length; i++) {
            int j = 1;
            for (; j < nums.length; j++) {
                if (Arrays.binarySearch(nums[j], nums[0][i]) < 0) {
                    break;
                }
            }
            if (j == nums.length) {
                result.add(nums[0][i]);
            }
        }
        return result;
    }
}