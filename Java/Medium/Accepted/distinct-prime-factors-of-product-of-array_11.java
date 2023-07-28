class Solution {
    public int distinctPrimeFactors(int[] nums) {
        
        int result = 0;
        for(int i = 2; i <= 1000; i++) {
            boolean isPrime = true;
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                for(int j = 0; j < nums.length; j++) {
                    if(nums[j] % i == 0) {
                        result++;
                        break;
                    }
                }
            }
        }
        return result;
    }
}