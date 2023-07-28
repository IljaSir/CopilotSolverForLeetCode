class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        
        int index = 0;
        for (int[] group : groups) {
            int i = 0;
            boolean found = false;
            while (index + i < nums.length) {
                if (nums[index + i] == group[i]) {
                    i++;
                    if (i == group.length) {
                        found = true;
                        break;
                    }
                } else {
                    i = 0;
                    index++;
                }
            }
            if (!found) {
                return false;
            }
            index += group.length;
        }
        return true;
    }
}