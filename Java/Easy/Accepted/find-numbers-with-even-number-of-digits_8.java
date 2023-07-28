class Solution {
    public int findNumbers(int[] nums) {
        
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int number = nums[i];
            int digitCount = 0;
            while(number > 0){
                number = number / 10;
                digitCount++;
            }
            if(digitCount % 2 == 0){
                count++;
            }
        }
        return count;
    }
}