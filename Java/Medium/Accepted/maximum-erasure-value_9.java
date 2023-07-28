class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int max=0;
        int sum=0;
        int start=0;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            while(set.contains(nums[i])){
                sum=sum-nums[start];
                set.remove(nums[start]);
                start++;
            }
            set.add(nums[i]);
            sum=sum+nums[i];
            max=Math.max(max,sum);
        }
        return max;
    }
}