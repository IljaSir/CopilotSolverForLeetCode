class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        
        int reverse = 0;
        int temp = num;
        while(temp > 0){
            reverse = reverse * 10 + temp % 10;
            temp = temp / 10;
        }
        return (num + reverse) % 10 == 0;
    }
}