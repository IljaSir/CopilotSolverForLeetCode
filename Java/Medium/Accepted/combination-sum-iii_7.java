class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        backtrack(result, new ArrayList<>(), nums, n, k, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int remain, int k, int start){
        if(remain < 0 || temp.size() > k){
            return;
        }
        if(remain == 0 && temp.size() == k){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(result, temp, nums, remain - nums[i], k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}