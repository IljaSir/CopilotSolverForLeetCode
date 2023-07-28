class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        
        for(int i=0; i<=num; i++){
            if(i + reverse(i) == num){
                return true;
            }
        }
        return false;
    }
    
    public int reverse(int num){
        int reverse = 0;
        while(num > 0){
            int rem = num % 10;
            reverse = reverse*10 + rem;
            num = num/10;
        }
        return reverse;
    }
}