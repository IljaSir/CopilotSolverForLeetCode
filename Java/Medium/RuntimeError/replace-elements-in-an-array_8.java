class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        
        int[] res = new int[nums.length];
        for (int[] op : operations) {
            int i = op[0]-1, j = op[1]-1;
            res[i]--;
            if (j+1 < nums.length) res[j+1]++;
        }
        for (int i = 1; i < nums.length; i++) res[i] += res[i-1];
        for (int i = 0; i < nums.length; i++) res[i] += nums[i];
        return res;
    }
}