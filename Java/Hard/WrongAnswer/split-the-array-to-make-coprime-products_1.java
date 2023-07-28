class Solution {
    public int findValidSplit(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        for(int i=1;i<n;i++){
            left[i] = gcd(left[i-1],nums[i]);
        }
        for(int i=n-2;i>=0;i--){
            right[i] = gcd(right[i+1],nums[i]);
        }
        for(int i=1;i<n-1;i++){
            if(gcd(left[i-1],right[i+1])==1){
                return i;
            }
        }
        return -1;
    }
    int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }
}