class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        
        int n = groups.length;
        int i = 0;
        for (int j = 0; j < n; j++) {
            int[] group = groups[j];
            int m = group.length;
            boolean found = false;
            while (i + m <= nums.length) {
                boolean match = true;
                for (int k = 0; k < m; k++) {
                    if (nums[i + k] != group[k]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    found = true;
                    break;
                }
                i++;
            }
            if (!found) {
                return false;
            }
            i += m;
        }
        return true;
    }
}