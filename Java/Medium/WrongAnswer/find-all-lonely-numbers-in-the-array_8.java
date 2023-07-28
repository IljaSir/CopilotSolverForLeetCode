class Solution {
    public List<Integer> findLonely(int[] nums) {
        
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i==0){
                if(nums[i]!=nums[i+1]){
                    ans.add(nums[i]);
                }
            }else if(i==n-1){
                if(nums[i]!=nums[i-1]){
                    ans.add(nums[i]);
                }
            }else{
                if(nums[i]!=nums[i-1] && nums[i]!=nums[i+1]){
                    ans.add(nums[i]);
                }
            }
        }
        return ans;
    }
}