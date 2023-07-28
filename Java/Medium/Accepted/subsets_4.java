class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int size = ans.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tmp = new ArrayList<Integer>(ans.get(j));
                tmp.add(nums[i]);
                ans.add(tmp);
            }
        }
        return ans;
    }
}