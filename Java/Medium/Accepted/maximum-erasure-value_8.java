class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n+1];
        for(int i = 1; i <= n; i++)
            prefix[i] = prefix[i-1] + nums[i-1];
        
        int max = 0;
        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();
        while(j < n){
            if(!set.contains(nums[j])){
                set.add(nums[j]);
                max = Math.max(max, prefix[j+1] - prefix[i]);
                j++;
            } else {
                set.remove(nums[i]);
                i++;
            }
        }
        return max;
    }
}