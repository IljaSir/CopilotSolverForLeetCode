class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int result = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);
                if(diff == 0) return sum;
                if(diff < min){
                    min = diff;
                    result = sum;
                }
                if(sum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }
}