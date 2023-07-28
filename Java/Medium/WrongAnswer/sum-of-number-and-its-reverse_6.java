class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        
        int num1 = num, num2 = 0;
        while(num1 > 0){
            num2 = num2 * 10 + num1 % 10;
            num1 /= 10;
        }
        return num == num2;
    }
}