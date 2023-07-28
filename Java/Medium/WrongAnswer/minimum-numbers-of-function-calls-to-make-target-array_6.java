class Solution {
    public int minOperations(int[] nums) {
        
        int max = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int zeroCount = 0;
            while(num > 0){
                if(num % 2 == 1){
                    count++;
                }
                num = num / 2;
                zeroCount++;
            }
            max = Math.max(max, zeroCount);
        }
        return count + max - 1;
    }
}