class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        permute(nums, result, temp);
        return result;
    }
    
    public void permute(int[] nums, List<List<Integer>> result, List<Integer> temp){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            permute(nums, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}