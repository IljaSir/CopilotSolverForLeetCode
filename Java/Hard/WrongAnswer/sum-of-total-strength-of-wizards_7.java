class Solution {
    public int totalStrength(int[] strength) {
        
        int len = strength.length;
        int mod = 1000000007;
        long[] left = new long[len];
        long[] right = new long[len];
        left[0] = 1;
        for(int i=1;i<len;i++){
            left[i] = (left[i-1] * strength[i-1]) % mod;
        }
        right[len-1] = 1;
        for(int i=len-2;i>=0;i--){
            right[i] = (right[i+1] * strength[i+1]) % mod;
        }
        long sum = 0;
        for(int i=0;i<len;i++){
            sum = (sum + (strength[i] * left[i] * right[i])) % mod;
        }
        return (int)sum;
    }
}