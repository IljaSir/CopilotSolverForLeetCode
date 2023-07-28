class Solution {
    public int minimumMountainRemovals(int[] nums) {
        
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        for(int i = 0; i < n; i++) {
            l[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    l[i] = Math.max(l[i], l[j] + 1);
                }
            }
        }
        for(int i = n - 1; i >= 0; i--) {
            r[i] = 1;
            for(int j = n - 1; j > i; j--) {
                if(nums[i] > nums[j]) {
                    r[i] = Math.max(r[i], r[j] + 1);
                }
            }
        }
        int ans = 0;
        for(int i = 1; i < n - 1; i++) {
            if(l[i] > 1 && r[i] > 1) {
                ans = Math.max(ans, l[i] + r[i] - 1);
            }
        }
        return n - ans;
    }
}