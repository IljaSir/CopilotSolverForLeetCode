class Solution {
    public int mostFrequent(int[] nums, int key) {
        
        int max = 0;
        int ans = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                count = 0;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == nums[i]) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count > max) {
                    max = count;
                    ans = nums[i];
                }
            }
        }
        return ans;
    }
}