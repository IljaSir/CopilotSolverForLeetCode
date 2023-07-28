class Solution {
    public int minimumDeletions(int[] nums) {
        
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = nums[0];
        r[n-1] = nums[n-1];
        for(int i=1; i<n; i++){
            l[i] = Math.min(l[i-1], nums[i]);
        }
        for(int i=n-2; i>=0; i--){
            r[i] = Math.max(r[i+1], nums[i]);
        }
        int ans = n;
        for(int i=0; i<n; i++){
            int left = i-1>=0?l[i-1]:Integer.MAX_VALUE;
            int right = i+1<n?r[i+1]:Integer.MAX_VALUE;
            if(left<nums[i] && nums[i]<right){
                ans = Math.min(ans, i+1+(n-i-1));
            }
        }
        return ans;
    }
}