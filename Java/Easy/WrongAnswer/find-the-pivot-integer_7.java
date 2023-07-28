class Solution {
    public int pivotInteger(int n) {
        
        int sum = 0;
        int sum1 = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }
        for(int i = 1; i <= n; i++){
            sum1 += i;
            if(sum1 == sum - sum1){
                return i;
            }
        }
        return -1;
    }
}