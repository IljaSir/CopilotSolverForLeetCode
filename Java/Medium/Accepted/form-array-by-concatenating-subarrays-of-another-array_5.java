class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        
        int i = 0;
        int j = 0;
        while (i < groups.length && j < nums.length) {
            int[] group = groups[i];
            if (group[0] != nums[j]) {
                j++;
                continue;
            }
            int k = 0;
            while (k < group.length && j < nums.length && group[k] == nums[j]) {
                k++;
                j++;
            }
            if (k == group.length) {
                i++;
            } else {
                j -= k - 1;
            }
        }
        return i == groups.length;
    }
}