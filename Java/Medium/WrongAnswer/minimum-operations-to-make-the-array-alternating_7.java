class Solution {
    public int minimumOperations(int[] nums) {
        
        int n = nums.length;
        int[] even = new int[n];
        int[] odd = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            even[i] = i % 2 == 0 ? nums[i] : nums[i] - 1;
            odd[i] = i % 2 == 0 ? nums[i] - 1 : nums[i];
        }
        for (int i = 0; i < n; i++) {
            if (i > 0 && even[i] == even[i - 1]) {
                even[i]++;
                res++;
            }
            if (i > 0 && odd[i] == odd[i - 1]) {
                odd[i]++;
                res++;
            }
        }
        return res;
    }
}