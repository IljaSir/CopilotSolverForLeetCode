class Solution {
    public int halveArray(int[] nums) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum / 2;
        if (sum % 2 == 1) {
            target++;
        }
        Arrays.sort(nums);
        int count = 0;
        int i = nums.length - 1;
        while (sum > target) {
            sum -= nums[i];
            i--;
            count++;
        }
        return count;
    }
}