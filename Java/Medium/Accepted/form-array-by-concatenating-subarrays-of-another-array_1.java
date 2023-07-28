class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums.length && j < groups.length) {
            if (nums[i] == groups[j][k]) {
                i++;
                k++;
                if (k == groups[j].length) {
                    k = 0;
                    j++;
                }
            } else {
                i = i - k + 1;
                k = 0;
            }
        }
        return j == groups.length;
    }
}