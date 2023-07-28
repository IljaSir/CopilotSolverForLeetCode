class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        
        int j = 0;
        for (int[] group : groups) {
            int i = 0;
            while (j < nums.length) {
                if (nums[j] == group[i]) {
                    i++;
                    j++;
                    if (i == group.length) {
                        break;
                    }
                } else {
                    j++;
                }
            }
            if (i != group.length) {
                return false;
            }
        }
        return true;
    }
}