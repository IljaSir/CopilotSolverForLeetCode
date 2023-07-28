class Solution {
    public List<Integer> findLonely(int[] nums) {
        
        List<Integer> lonely = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                if(nums[i] != nums[i+1]){
                    lonely.add(nums[i]);
                }
            } else if(i == nums.length - 1){
                if(nums[i] != nums[i-1]){
                    lonely.add(nums[i]);
                }
            } else {
                if(nums[i] != nums[i-1] && nums[i] != nums[i+1]){
                    lonely.add(nums[i]);
                }
            }
        }
        return lonely;
    }
}