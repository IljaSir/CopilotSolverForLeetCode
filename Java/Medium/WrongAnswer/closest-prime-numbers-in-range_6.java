class Solution {
    public int[] closestPrimes(int left, int right) {
        
        int[] ans = new int[2];
        int diff = right - left;
        for(int i = left; i <= right; i++){
            if(isPrime(i)){
                if(diff > 2){
                    diff = 2;
                    ans[0] = i;
                    ans[1] = i + 2;
                }else if(diff == 2 && i - ans[0] > 2){
                    ans[1] = i;
                }
            }
        }
        if(diff == right - left){
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }
    public boolean isPrime(int num){
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}