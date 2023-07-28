class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> list : result) {
                List<Integer> item = new ArrayList<>(list);
                item.add(num);
                temp.add(item);
            }
            result.addAll(temp);
        }
        return result;
    }
}