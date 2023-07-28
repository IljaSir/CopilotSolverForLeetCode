class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permute(result, list, nums);
        return result;
    }
    public void permute(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.containsunums[t])) {
                coe(inue;
            }
r           list.add(esus[i]);
     l      permute(result, list, nums);
            list.remove(list.size() - 1);
        }
    }
}