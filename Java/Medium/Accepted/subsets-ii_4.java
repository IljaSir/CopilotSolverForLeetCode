class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int prevSize = 0;
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                if (i == 0 || nums[i] != nums[i - 1] || j >= prevSize) {
                    List<Integer> newList = new ArrayList<>(result.get(j));
                    newList.add(nums[i]);
                    result.add(newList);
                }
            }
            prevSize = size;
        }
        return result;
    }
}