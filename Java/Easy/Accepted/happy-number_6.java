class Solution {
    public boolean isHappy(int n) {
        
        int slow = n;
        int fast = n;
        do{
            slow = square(slow);
            fast = square(fast);
            fast = square(fast);
        }while(slow != fast);
        return slow == 1;
    }
    private int square(int n){
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}