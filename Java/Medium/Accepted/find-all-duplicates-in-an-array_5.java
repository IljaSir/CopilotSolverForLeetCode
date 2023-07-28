class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                list.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return list;
    }
}