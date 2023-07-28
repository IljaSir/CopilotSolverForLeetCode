class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int half = sum / 2;
        int temp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            temp += nums[i];
            result.add(nums[i]);
            if (temp > half) {
                break;
            }
        }
        return result;
    }
}