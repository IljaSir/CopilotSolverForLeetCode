class Solution {
    public int subarrayLCM(int[] nums, int k) {
        
        int count = 0;
        for(int i=0; i<nums.length; i++){
            int lcm = nums[i];
            if(lcm%k == 0){
                count++;
            }
            for(int j=i+1; j<nums.length; j++){
                lcm = lcm(lcm, nums[j]);
                if(lcm%k == 0){
                    count++;
                }
            }
        }
        return count;
    }
    private int lcm(int a, int b){
        return a*b/gcd(a, b);
    }
    private int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return gcd(b%a, a);
    }
}