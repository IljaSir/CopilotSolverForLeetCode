class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        
        int n = groups.length;
        int m = nums.length;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            int[] group = groups[i];
            int k = 0;
            while (j < m && k < group.length) {
                if (group[k] == nums[j]) {
                    k++;
                }
                j++;
            }
            if (k == group.length) {
                i++;
            } else {
                j = j - k + 1;
            }
        }
        return i == n;
    }
}