class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        int[] freq = new int[max+1];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        int ans = 0;
        for(int i=0;i<numsDivide.length;i++){
            if(numsDivide[i]%min != 0){
                return -1;
            }
            int num = numsDivide[i]/min;
            for(int j=max;j>=1;j--){
                while(num%j == 0 && freq[j] > 0){
                    freq[j]--;
                    num = num/j;
                }
            }
            if(num > 1){
                return -1;
            }
            ans += freq[num];
            freq[num] = 0;
        }
        return ans;
    }
}