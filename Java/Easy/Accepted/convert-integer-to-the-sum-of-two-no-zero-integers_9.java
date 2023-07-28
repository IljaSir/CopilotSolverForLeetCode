class Solution {
    public int[] getNoZeroIntegers(int n) {
        
        int[] result = new int[2];
        for(int i = 1; i < n; i++){
            if(!isZero(i) && !isZero(n-i)){
                result[0] = i;
                result[1] = n - i;
                break;
            }
        }
        return result;
    }
    public boolean isZero(int n){
        while(n > 0){
            if(n%10 == 0){
                return true;
            }
            n /= 10;
        }
        return false;
    }
}