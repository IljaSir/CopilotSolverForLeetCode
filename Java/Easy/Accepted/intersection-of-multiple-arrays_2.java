class Solution {
    public List<Integer> intersection(int[][] nums) {
        
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
        }
        for (int i = 0; i < nums[0].length; i++) {
            boolean flag = true;
            for (int j = 1; j < nums.length; j++) {
                if (Arrays.binarySearch(nums[j], nums[0][i]) < 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(nums[0][i]);
            }
        }
        return result;
    }
}