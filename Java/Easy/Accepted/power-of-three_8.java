class Solution {
    public boolean isPowerOfThree(int n) {
        
        if(n == 1){
            return true;
        }
        if(n == 0){
            return false;
        }
        int rem = n%3;
        if(rem != 0){
            return false;
        }
        return isPowerOfThree(n/3);
    }
}