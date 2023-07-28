class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        
        int i = 0;
        for (int[] group : groups) {
            int n = group.length;
            int j = i;
            while (j <= nums.length - n) {
                boolean match = true;
                for (int k = 0; k < n; k++) {
                    if (nums[j + k] != group[k]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    i = j + n;
                    break;
                }
                j++;
            }
            if (j == nums.length - n + 1) {
                return false;
            }
        }
        return true;
    }
}