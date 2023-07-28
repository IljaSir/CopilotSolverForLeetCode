class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        Arrays.sort(nums);
        int temp = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            temp += nums[i];
            list.add(nums[i]);
            if (temp > sum - temp) {
                break;
            }
        }
        return list;
    }
}