class Solution {
    public int minOperations(int[] nums) {
        
        int max = 0;
        int count = 0;
        for(int num: nums){
            int temp = 0;
            while(num > 0){
                if(num % 2 == 1){
                    num--;
                    count++;
                }else{
                    num /= 2;
                    temp++;
                }
            }
            max = Math.max(max, temp);
        }
        return count + max;
    }
}