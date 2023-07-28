class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int j = nums[i];
                while(set.contains(j)){
                    j++;
                }
                res = Math.max(res, j-nums[i]);
            }
        }
        return res;
    }
}