class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        
        int i = 0;
        for (int[] group : groups) {
            int j = 0;
            while (i < nums.length) {
                if (nums[i] == group[j]) {
                    j++;
                    if (j == group.length) {
                        i++;
                        break;
                    }
                }
                i++;
            }
            if (j != group.length) {
                return false;
            }
        }
        return true;
    }
}