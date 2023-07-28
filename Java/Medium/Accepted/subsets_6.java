class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int resultSize = result.size();
            for (int j = 0; j < resultSize; j++) {
                List<Integer> newList = new ArrayList<Integer>(result.get(j));
                newList.add(nums[i]);
                result.add(newList);
            }
        }
        return result;
    }
}