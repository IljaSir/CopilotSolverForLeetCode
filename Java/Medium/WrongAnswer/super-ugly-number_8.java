class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        int[] ugly = new int[n];
        int[] index = new int[primes.length];
        ugly[0] = 1;
        for(int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                min = Math.min(min, ugly[index[j]] * primes[j]);
            }
            for(int j = 0; j < primes.length; j++){
                if(min == ugly[index[j]] * primes[j]){
                    index[j]++;
                }
            }
            ugly[i] = min;
        }
        return ugly[n - 1];
    }
}