class Solution {
    public int sumOfUnique(int[] nums) {
        
        int sum = 0;
        int[] count = new int[101];
        for(int i:nums){
            count[i]++;
        }
        for(int i=0;i<101;i++){
            if(count[i]==1){
                sum+=i;
            }
        }
        return sum;
    }
}