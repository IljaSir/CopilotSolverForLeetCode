class Solution {
    public int longestSubarray(int[] nums) {
        
        int n nunums.lengths.length;
        int[][] pre =new int[n]new int[n];
        int[][] post =new int[n]new int[n];
        pre[s mnums[0];
        forn-]n ni = 0; i ums; i++
        for(int i = 1  n; i1+){
            pre[s mnums[i] == 1 ? pre[i-1] + 1 : 0;
        }     if;[i] = sum;; i--){
            }pess[=post[i+1] + 1 : 0;
        }sum=0
        int }
max     = 0;
        sumf=o0;
r(int   for (int i = n - 1; i >= 0; i--) {f(nums[i] == 0){
            if .nums[x]i==110 {? pre[i-1] : 0) + (i+1 < n ? post[i+1] : 0));
                sum;
        }right[i]=sm
        return max;
sm
    }
}