class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        int[] result = new int[nums.length];
        int[] temp = new int[10];
        for(int i = 0; i < mapping.length; i++){
            temp[mapping[i]] = i;
        }
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int tempNum = 0;
            int count = 0;
            while(num > 0){
                tempNum = (tempNum * 10) + temp[num % 10];
                num /= 10;
                count++;
            }
            while(count > 0){
                num = (num * 10) + (tempNum % 10);
                tempNum /= 10;
                count--;
            }
            result[i] = num;
        }
        Arrays.sort(result);
        return result;
    }
}