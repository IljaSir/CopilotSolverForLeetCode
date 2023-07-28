class Solution {
    public int maximumSum(int[] nums) {
        
        int max = -1;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(sumOfDigits(nums[i]) == sumOfDigits(nums[j])){
                    max = Math.max(max, nums[i] + nums[j]);
                }
            }
        }
        return max;
    }
    
    private int sumOfDigits(int n){
        int sum = 0;
        while(n > 0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}