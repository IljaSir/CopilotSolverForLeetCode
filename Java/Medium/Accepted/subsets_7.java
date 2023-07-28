class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        result.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newResult = new ArrayList<>();
            for (List<Integer> list : result) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(num);
                newResult.add(newList);
            }
            result.addAll(newResult);
        }
        return result;
    }
}