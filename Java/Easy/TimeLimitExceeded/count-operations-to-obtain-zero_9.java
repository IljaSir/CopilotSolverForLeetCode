class Solution {
    public int countOperations(int num1, int num2) {
        
        if(num1 == num2) return 0;
        if(num1 < num2) return countOperations(num2, num1);
        int res = 0;
        while(num1 != 0 && num2 != 0){
            if(num1 >= num2 * 2){
                res += num1 / (num2 * 2);
                num1 %= num2 * 2;
            }else{
                res += 1;
                num1 -= num2;
            }
        }
        return res;
    }
}