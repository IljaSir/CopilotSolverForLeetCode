class Solution {
    public int minimumOperations(int[] nums) {
        
        int n = nums.length;
        int[] odd = new int[n];
        int[] even = new int[n];
        odd[0] = 1;
        even[0] = 2;
        for (int i = 1; i < n; i++) {
            odd[i] = odd[i-1] + 2;
            even[i] = even[i-1] + 2;
        }
        int res = Integer.MAX_VALUE;
        int preOdd = 0, preEven = 0;
        for (int i = 0; i < n; i++) {
            int cur = i % 2 == 0 ? odd[i] : even[i];
            int pre = i % 2 == 0 ? preOdd : preEven;
            int diff = Math.abs(nums[i] - cur);
            if (nums[i] <= cur) {
                res = Math.min(res, pre + diff);
            } else {
                res = Math.min(res, pre + diff + 1);
            }
            if (i % 2 == 0) {
                preOdd += diff;
            } else {
                preEven += diff;
            }
        }
        return res;
    }
}