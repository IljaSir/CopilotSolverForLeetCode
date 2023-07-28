class Solution {
    public boolean validPartition(int[] nums) {
        
        int[] count = new int[1000001];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int[] left = new int[1000001];
        int[] right = new int[1000001];
        for (int i = 1; i < 1000001; i++) {
            left[i] = left[i - 1] + count[i];
            right[i] = right[i - 1] + (left[i] == 0 ? 0 : count[i]);
        }
        for (int i = 1; i < 1000001; i++) {
            if (left[i] == 0) {
                continue;
            }
            if (count[i] == left[i]) {
                return true;
            }
            if (count[i] == left[i] - 1) {
                if (i < 1000000 && count[i + 1] > 0) {
                    return true;
                }
                if (i > 1 && count[i - 1] > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}