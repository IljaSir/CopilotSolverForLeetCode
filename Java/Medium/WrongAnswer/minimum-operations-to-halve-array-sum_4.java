class Solution {
    public int halveArray(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        Arrays.sort(nums);
        int count = 0;
        int total = 0;
        for(int i = n - 1; i >= 0; i--) {
            total += nums[i];
            count++;
            if(total >= sum / 2) {
                break;
            }
        }
        return count;
    }
}