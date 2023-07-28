class Solution {
    public boolean isHappy(int n) {
        
        int sum = 0, rem = 0;
        while(n > 0){
            rem = n % 10;
            sum = sum + rem * rem;
            n = n / 10;
        }
        if(sum == 1){
            return true;
        }else if(sum == 4){
            return false;
        }else{
            return isHappy(sum);
        }
    }
}