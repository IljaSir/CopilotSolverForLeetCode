class Solution {
    public int minOperations(int[] nums) {
        
        int count = 0;
        int max = 0;
        for(int num: nums){
            int zeros = 0;
            while(num>0){
                if(num%2==1){
                    count++;
                }
                num/=2;
                zeros++;
            }
            max = Math.max(max, zeros);
        }
        return count + max - 1;
    }
}