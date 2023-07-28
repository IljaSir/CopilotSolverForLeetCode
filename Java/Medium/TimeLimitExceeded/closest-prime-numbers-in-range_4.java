class Solution {
    public int[] closestPrimes(int left, int right) {
        
        int[] ans = new int[2];
        int min = Integer.MAX_VALUE;
        for(int i = left; i <= right; i++){
            if(isPrime(i)){
                for(int j = i+1; j <= right; j++){
                    if(isPrime(j)){
                        if(j-i < min){
                            min = j-i;
                            ans[0] = i;
                            ans[1] = j;
                        }
                        break;
                    }
                }
            }
        }
        if(ans[0] == 0){
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }
    
    public boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}