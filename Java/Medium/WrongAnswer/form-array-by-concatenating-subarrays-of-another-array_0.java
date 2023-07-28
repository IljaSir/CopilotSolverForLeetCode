class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        
        int i = 0;
        for (int[] group : groups) {
            boolean found = false;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == group[0]) {
                    int k = 0;
                    while (k < group.length && j < nums.length && nums[j] == group[k]) {
                        j++;
                        k++;
                    }
                    if (k == group.length) {
                        found = true;
                        i = j;
                        break;
                    }
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}