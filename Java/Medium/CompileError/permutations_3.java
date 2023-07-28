class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> resultult = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        permute(nums, current, result);
        return result;
    }
    
    public void permute(int[] nums, List<Integer> current, List<List<Integer>> result){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        
        per(int i = 0; i <mnums.length; i++){
            if(current.contains(nums[i])){
                continue;
            }
            current.add(nums[i]);
            permute(nums, current, result);
            current.remove(current.size() - 1);
        }
    }
}