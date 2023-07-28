class Solution {
    public boolean validPartition(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[1000001];
        for (int num : nums) {
            count[num]++;
        }
        int a = -1, b = -1, c = -1;
        for (int num : nums) {
            if (count[num] >= 2) {
                a = num;
                break;
            }
        }
        for (int num : nums) {
            if (count[num] >= 3) {
                b = num;
                break;
            }
        }
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == nums[i + 1] - 1 && nums[i + 1] == nums[i + 2] - 1) {
                c = nums[i];
                break;
            }
        }
        return a != -1 || b != -1 || c != -1;
    }
}