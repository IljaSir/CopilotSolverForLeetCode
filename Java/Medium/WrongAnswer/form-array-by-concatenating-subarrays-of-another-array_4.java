class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        
        int i = 0;
        int j = 0;
        while (i < groups.length && j < nums.length) {
            int[] group = groups[i];
            int k = 0;
            while (k < group.length && j < nums.length) {
                if (group[k] != nums[j]) {
                    j++;
                } else {
                    k++;
                    j++;
                }
            }
            if (k == group.length) {
                i++;
            }
        }
        return i == groups.length;
    }
}