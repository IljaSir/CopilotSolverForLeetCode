class Solution {
    public boolean validPartition(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[1000001];
        for (int i = 0; i < n; ++i) {
            ++count[nums[i]];
        }
        int i = 0;
        while (i < n && count[nums[i]] == 1) {
            ++i;
        }
        int j = n - 1;
        while (j >= i && count[nums[j]] == 1) {
            --j;
        }
        if (i == j) {
            return false;
        }
        int x = nums[i];
        while (i < n && nums[i] == x) {
            ++i;
        }
        while (i < n && count[nums[i]] == 1) {
            ++i;
        }
        int y = nums[j];
        while (j >= 0 && nums[j] == y) {
            --j;
        }
        while (j >= 0 && count[nums[j]] == 1) {
            --j;
        }
        if (i == j) {
            return true;
        }
        if (x + 1 == y && count[x] >= 2 && count[y] >= 2) {
            return true;
        }
        return false;
    }
}