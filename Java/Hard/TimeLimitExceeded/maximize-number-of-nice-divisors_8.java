class Solution {
    public int maxNiceDivisors(int primeFactors) {
        
        int mod = 1000000007;
        if(primeFactors <= 3){
            return primeFactors;
        }
        long res = 1;
        while(primeFactors > 4){
            res = (res * 3) % mod;
            primeFactors -= 3;
        }
        return (int)((res * primeFactors) % mod);
    }
}