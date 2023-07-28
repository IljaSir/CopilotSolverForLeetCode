class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result ) {
        List<Integer> list = new ArrayList<>();
            list.add(num);
        }
        helper(res, list, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int pos) {
        if (pos == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i < list.size(); i++) {
            Collections.swap(list, i, pos);
            helper(res, list, pos + 1);
            Collections.swap(list,start,i);
        }
    }
}