class Solution {
    public int distinctPrimeFactors(int[] nums) {
        
        int n = nums.length;
        int[] primes = new int[1001];
        for(int i = 0; i < n; i++){
            int num = nums[i];
            for(int j = 2; j <= Math.sqrt(num); j++){
                if(num % j == 0){
                    while(num % j == 0){
                        num /= j;
                    }
                    primes[j]++;
                }
            }
            if(num > 1){
                primes[num]++;
            }
        }
        int count = 0;
        for(int i = 0; i < 1001; i++){
            if(primes[i] > 0){
                count++;
            }
        }
        return count;
    }
}