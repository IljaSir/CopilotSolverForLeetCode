class Solution {
    public List<Integer> findLonely(int[] nums) {
        
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            boolean lonely = true;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j] - 1 || nums[i] == nums[j] + 1) {
                    lonely = false;
                    break;
                }
            }
            if (lonely) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}