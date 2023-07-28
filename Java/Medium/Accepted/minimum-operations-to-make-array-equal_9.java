class Solution {
    public int minOperations(int n) {
        
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += (2*i)+1;
        }
        int res = sum/n;
        int count = 0;
        for(int i=0;i<n;i++){
            if((2*i)+1>res){
                count += ((2*i)+1)-res;
            }
        }
        return count;
    }
}