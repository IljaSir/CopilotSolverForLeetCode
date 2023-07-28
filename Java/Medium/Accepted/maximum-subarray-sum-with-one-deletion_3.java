class Solution {
    public int maximumSum(int[] arr) {
        
        int n = arr.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = arr[0];
        for(int i = 1; i < n; i++){
            dp1[i] = Math.max(arr[i], dp1[i-1] + arr[i]);
        }
        dp2[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            dp2[i] = Math.max(arr[i], dp2[i+1] + arr[i]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, dp1[i]);
            if(i > 0 && i < n-1){
                ans = Math.max(ans, dp1[i-1] + dp2[i+1]);
            }
        }
        return ans;
    }
}