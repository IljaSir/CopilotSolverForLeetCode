class Solution {
    public int sumOfUnique(int[] nums) {
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) sum += nums[i];
        }
        return sum;
    }
}