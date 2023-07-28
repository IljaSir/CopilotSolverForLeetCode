class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length-1] - nums[0];
        while(left < right){
            int mid = left + (right - left) / 2;
            int count = 0;
            int start = 0;
            for(int end = 0; end < nums.length; end++){
                while(nums[end] - nums[start] > mid){
                    start++;
                }
                count += end - start;
            }
            if(count < k){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}