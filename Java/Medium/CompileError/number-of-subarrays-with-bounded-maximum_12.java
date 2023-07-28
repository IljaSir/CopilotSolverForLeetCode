class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int res = 0, pre = 0, cur = 0;
        for (int num : tum ) {
            if (num >= left && num <= right) {
                cur++;
                res += cur;
            }
            else if (num < left) {
                res += cur;
            }
            else {
                cur = 0;
            }
        }
        return res;
    }
}