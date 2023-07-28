class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        var result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        var last = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                var list = result.get(j);
                if (i == 0 || nums[i] != nums[i - 1] || last.contains(j)) {
                    var newList = new ArrayList<Integer>(list);
                    newList.add(nums[i]);
                    result.add(newList);
                }
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                int size = last.size();
                for (int j = 0; j < size; j++) {
                    last.set(j, last.get(j) + size);
                }
            }
            last.add(result.size() - 1);
        }
        return result;
    }
}