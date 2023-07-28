class Solution {
    public int minimumOperations(int[] nums) {
        
        int n = nums.length;
        int[] odd = new int[n];
        int[] even = new int[n];
        int[] odd2 = new int[n];
        int[] even2 = new int[n];
        odd[0] = 1;
        even[0] = 0;
        odd2[0] = 0;
        even2[0] = 1;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                odd[i] = odd[i - 1] + 1;
                even[i] = even[i - 1];
                odd2[i] = odd2[i - 1];
                even2[i] = even2[i - 1] + 1;
            } else {
                odd[i] = odd[i - 1];
                even[i] = even[i - 1] + 1;
                odd2[i] = odd2[i - 1] + 1;
                even2[i] = even2[i - 1];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int o = odd[i];
            int e = even[i];
            if (i % 2 == 0) {
                o = odd2[i];
                e = even2[i];
            }
            int op = 0;
            if (nums[i] % 2 == 1) {
                op = Math.max(0, o - nums[i] / 2);
            } else {
                op = Math.max(0, o - nums[i] / 2 + 1);
            }
            min = Math.min(min, op + e);
        }
        return min;
    }
}